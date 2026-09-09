package com.example.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.data.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserProfileRepository(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )

    private val _userProfile = MutableStateFlow(loadProfile())
    val userProfile: StateFlow<UserProfile> = _userProfile.asStateFlow()

    private fun loadProfile(): UserProfile {
        val isCompleted = prefs.getBoolean(KEY_IS_COMPLETED, false)
        val age = prefs.getString(KEY_AGE, "") ?: ""
        val gender = prefs.getString(KEY_GENDER, "") ?: ""
        val customGender = prefs.getString(KEY_CUSTOM_GENDER, "") ?: ""
        val educationLevel = prefs.getString(KEY_EDUCATION, "") ?: ""
        val experience = prefs.getString(KEY_EXPERIENCE, "") ?: ""

        return UserProfile(
            age = age,
            gender = gender,
            customGender = customGender,
            educationLevel = educationLevel,
            iChingExperience = experience,
            isCompleted = isCompleted
        )
    }

    fun saveProfile(profile: UserProfile) {
        prefs.edit()
            .putBoolean(KEY_IS_COMPLETED, true)
            .putString(KEY_AGE, profile.age.trim())
            .putString(KEY_GENDER, profile.gender)
            .putString(KEY_CUSTOM_GENDER, profile.customGender.trim())
            .putString(KEY_EDUCATION, profile.educationLevel)
            .putString(KEY_EXPERIENCE, profile.iChingExperience)
            .apply()

        _userProfile.value = profile.copy(isCompleted = true)
    }

    fun clearProfile() {
        prefs.edit().clear().apply()
        _userProfile.value = UserProfile()
    }

    companion object {
        private const val PREFS_NAME = "iching_user_profile_prefs"
        private const val KEY_IS_COMPLETED = "is_profile_completed"
        private const val KEY_AGE = "profile_age"
        private const val KEY_GENDER = "profile_gender"
        private const val KEY_CUSTOM_GENDER = "profile_custom_gender"
        private const val KEY_EDUCATION = "profile_education"
        private const val KEY_EXPERIENCE = "profile_experience"
    }
}
