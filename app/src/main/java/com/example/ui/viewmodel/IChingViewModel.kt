package com.example.ui.viewmodel

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.HexagramLibrary
import com.example.data.db.IChingDatabase
import com.example.data.db.ReadingEntity
import com.example.data.model.Hexagram
import com.example.data.model.TossResult
import com.example.data.model.Trigram
import com.example.data.model.UserProfile
import com.example.data.repository.ReadingRepository
import com.example.data.repository.UserProfileRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import kotlin.random.Random

data class DivinationUiState(
    val question: String = "",
    val tosses: List<TossResult> = emptyList(), // 0 to 6 tosses
    val isTossing: Boolean = false,
    val tossSeed: Long = 0L,
    val currentCoinValues: Triple<Int, Int, Int> = Triple(3, 2, 3),
    val primaryHexagram: Hexagram? = null,
    val changingLineIndices: List<Int> = emptyList(), // 1-based (1 to 6)
    val transformedHexagram: Hexagram? = null,
    val isSaved: Boolean = false,
    val reflectionNotes: String = ""
)

class IChingViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ReadingRepository
    private val userProfileRepository: UserProfileRepository

    // User Profile State
    val userProfile: StateFlow<UserProfile>

    private val _isEditingProfile = MutableStateFlow(false)
    val isEditingProfile: StateFlow<Boolean> = _isEditingProfile.asStateFlow()

    init {
        val database = IChingDatabase.getDatabase(application)
        repository = ReadingRepository(database.readingDao())
        userProfileRepository = UserProfileRepository(application)
        userProfile = userProfileRepository.userProfile
    }

    fun openProfileEditor() {
        _isEditingProfile.value = true
    }

    fun closeProfileEditor() {
        _isEditingProfile.value = false
    }

    fun saveUserProfile(profile: UserProfile) {
        userProfileRepository.saveProfile(profile)
        _isEditingProfile.value = false
    }

    // Journal Flow
    val allReadings: StateFlow<List<ReadingEntity>> = repository.allReadings
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // Divination State
    private val _divinationState = MutableStateFlow(DivinationUiState())
    val divinationState: StateFlow<DivinationUiState> = _divinationState.asStateFlow()

    // Explorer & Global Search State
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _isSearchActive = MutableStateFlow(false)
    val isSearchActive: StateFlow<Boolean> = _isSearchActive.asStateFlow()

    private val _selectedTrigramFilter = MutableStateFlow<Trigram?>(null)
    val selectedTrigramFilter: StateFlow<Trigram?> = _selectedTrigramFilter.asStateFlow()

    private val _inspectedHexagram = MutableStateFlow<Hexagram?>(null)
    val inspectedHexagram: StateFlow<Hexagram?> = _inspectedHexagram.asStateFlow()

    // Daily Hexagram
    val dailyHexagram: Hexagram by lazy {
        val cal = Calendar.getInstance()
        val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)
        val index = (dayOfYear % 64) + 1
        HexagramLibrary.getByNumberOrThrow(index)
    }

    fun updateQuestion(question: String) {
        _divinationState.update { it.copy(question = question) }
    }

    fun updateReflectionNotes(notes: String) {
        _divinationState.update { it.copy(reflectionNotes = notes) }
    }

    /**
     * Authentic 3-Coin Toss:
     * - Each coin is 2 (Tails / Yin) or 3 (Heads / Yang)
     * - Sum:
     *   6: Old Yin (Changing ⚋ -> ⚊)
     *   7: Young Yang (Stable ⚊)
     *   8: Young Yin (Stable ⚋)
     *   9: Old Yang (Changing ⚊ -> ⚋)
     */
    fun tossSingleLine() {
        val currentState = _divinationState.value
        if (currentState.tosses.size >= 6 || currentState.isTossing) return

        triggerHapticFeedback()

        viewModelScope.launch {
            _divinationState.update { it.copy(isTossing = true, tossSeed = System.currentTimeMillis()) }

            // Coin toss simulation delay
            delay(550)

            val c1 = if (Random.nextBoolean()) 3 else 2
            val c2 = if (Random.nextBoolean()) 3 else 2
            val c3 = if (Random.nextBoolean()) 3 else 2
            val sum = c1 + c2 + c3

            val nextIndex = currentState.tosses.size
            val newToss = TossResult(
                lineIndex = nextIndex,
                coinValues = Triple(c1, c2, c3),
                sum = sum
            )
            val updatedTosses = currentState.tosses + newToss

            if (updatedTosses.size == 6) {
                // Completed all 6 lines! Compute hexagrams
                val primaryLines = updatedTosses.map { it.isYang }
                val primaryHex = HexagramLibrary.findByLines(primaryLines)

                val changingIndices = updatedTosses
                    .filter { it.isChanging }
                    .map { it.lineIndex + 1 }

                val transformedHex = if (changingIndices.isNotEmpty()) {
                    val transformedLines = updatedTosses.map { it.transformedIsYang }
                    HexagramLibrary.findByLines(transformedLines)
                } else {
                    null
                }

                _divinationState.update {
                    it.copy(
                        tosses = updatedTosses,
                        currentCoinValues = Triple(c1, c2, c3),
                        isTossing = false,
                        primaryHexagram = primaryHex,
                        changingLineIndices = changingIndices,
                        transformedHexagram = transformedHex
                    )
                }
            } else {
                _divinationState.update {
                    it.copy(
                        tosses = updatedTosses,
                        currentCoinValues = Triple(c1, c2, c3),
                        isTossing = false
                    )
                }
            }
        }
    }

    /**
     * Cast all remaining lines in one go for immediate consultation.
     */
    fun quickCastAll() {
        if (_divinationState.value.isTossing) return
        triggerHapticFeedback()

        val tosses = mutableListOf<TossResult>()
        for (i in 0 until 6) {
            val c1 = if (Random.nextBoolean()) 3 else 2
            val c2 = if (Random.nextBoolean()) 3 else 2
            val c3 = if (Random.nextBoolean()) 3 else 2
            tosses.add(
                TossResult(
                    lineIndex = i,
                    coinValues = Triple(c1, c2, c3),
                    sum = c1 + c2 + c3
                )
            )
        }

        val primaryLines = tosses.map { it.isYang }
        val primaryHex = HexagramLibrary.findByLines(primaryLines)

        val changingIndices = tosses
            .filter { it.isChanging }
            .map { it.lineIndex + 1 }

        val transformedHex = if (changingIndices.isNotEmpty()) {
            val transformedLines = tosses.map { it.transformedIsYang }
            HexagramLibrary.findByLines(transformedLines)
        } else {
            null
        }

        _divinationState.update {
            it.copy(
                tosses = tosses,
                currentCoinValues = tosses.last().coinValues,
                isTossing = false,
                tossSeed = System.currentTimeMillis(),
                primaryHexagram = primaryHex,
                changingLineIndices = changingIndices,
                transformedHexagram = transformedHex
            )
        }
    }

    fun resetDivination() {
        _divinationState.value = DivinationUiState()
    }

    fun saveCurrentReading() {
        val state = _divinationState.value
        val primary = state.primaryHexagram ?: return
        if (state.isSaved) return

        viewModelScope.launch {
            val reading = ReadingEntity(
                question = state.question.ifBlank { "Unspoken Inquiry" },
                primaryHexagramNumber = primary.number,
                changingLines = state.changingLineIndices.joinToString(","),
                transformedHexagramNumber = state.transformedHexagram?.number,
                notes = state.reflectionNotes
            )
            repository.insert(reading)
            _divinationState.update { it.copy(isSaved = true) }
        }
    }

    fun deleteReading(reading: ReadingEntity) {
        viewModelScope.launch {
            repository.delete(reading)
        }
    }

    fun updateReadingNotes(reading: ReadingEntity, newNotes: String) {
        viewModelScope.launch {
            repository.update(reading.copy(notes = newNotes))
        }
    }

    // Search and filter
    fun openSearch() {
        _isSearchActive.value = true
    }

    fun closeSearch() {
        _isSearchActive.value = false
        _searchQuery.value = ""
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onTrigramFilterChange(trigram: Trigram?) {
        _selectedTrigramFilter.value = if (_selectedTrigramFilter.value == trigram) null else trigram
    }

    fun inspectHexagram(hexagram: Hexagram?) {
        _inspectedHexagram.value = hexagram
    }

    private fun triggerHapticFeedback() {
        try {
            val context = getApplication<Application>()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                vibratorManager?.defaultVibrator?.vibrate(
                    VibrationEffect.createOneShot(35, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                @Suppress("DEPRECATION")
                val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createOneShot(35, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator?.vibrate(35)
                }
            }
        } catch (_: Exception) {
            // Ignore if vibration is unavailable
        }
    }
}
