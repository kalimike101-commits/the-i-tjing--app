package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Hexagram
import com.example.data.model.TossResult
import com.example.ui.components.AncientCoin
import com.example.ui.components.HexagramGlyph
import com.example.ui.theme.BrightCinnabar
import com.example.ui.theme.CinnabarRed
import com.example.ui.theme.DeepGold
import com.example.ui.theme.ImperialGold
import com.example.ui.theme.SoftGold
import com.example.ui.theme.WarmBronze
import com.example.ui.viewmodel.DivinationUiState
import com.example.ui.viewmodel.IChingViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DivinationScreen(
    viewModel: IChingViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.divinationState.collectAsState()
    val scrollState = rememberScrollState()

    val promptSuggestions = listOf(
        "Guidance for today",
        "How to approach this change?",
        "Finding clarity in conflict",
        "The right action for my project"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Title & Tagline with Profile Button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 12.dp)
        ) {
            // Invisible balance spacer on left
            Spacer(modifier = Modifier.size(40.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "易經",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "I-Ching Oracle",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            IconButton(
                onClick = { viewModel.openProfileEditor() },
                modifier = Modifier
                    .size(40.dp)
                    .testTag("button_open_profile")
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Seeker Profile",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        // Inquiry Card (Only editable before casting completes)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "Your Inquiry / Question",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = state.question,
                    onValueChange = { viewModel.updateQuestion(it) },
                    placeholder = { Text("What situation or question is in your mind?") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("inquiry_input"),
                    enabled = state.tosses.isEmpty(),
                    singleLine = false,
                    maxLines = 3,
                    shape = RoundedCornerShape(12.dp)
                )

                if (state.tosses.isEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Or choose a theme for contemplation:",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        promptSuggestions.forEach { prompt ->
                            FilterChip(
                                selected = state.question == prompt,
                                onClick = { viewModel.updateQuestion(prompt) },
                                label = { Text(prompt, fontSize = 11.sp) }
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Casting Section (When in progress: 0 to 5 tosses completed)
        if (state.tosses.size < 6) {
            CastingInProgressView(
                state = state,
                onTossSingle = { viewModel.tossSingleLine() },
                onQuickCast = { viewModel.quickCastAll() }
            )
        } else {
            // Hexagram Complete: Divination Result View
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically()
            ) {
                DivinationResultView(
                    state = state,
                    onSave = { viewModel.saveCurrentReading() },
                    onNotesChange = { viewModel.updateReflectionNotes(it) },
                    onReset = { viewModel.resetDivination() }
                )
            }
        }

        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
private fun CastingInProgressView(
    state: DivinationUiState,
    onTossSingle: () -> Unit,
    onQuickCast: () -> Unit
) {
    val currentLineNumber = state.tosses.size + 1
    val lineNames = listOf("First (初 - Bottom)", "Second (二)", "Third (三)", "Fourth (四)", "Fifth (五)", "Sixth (上 - Top)")

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Casting Line $currentLineNumber of 6",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = lineNames.getOrElse(state.tosses.size) { "Line $currentLineNumber" },
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Three Ancient Coins Display
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AncientCoin(
                    value = state.currentCoinValues.first,
                    isTossing = state.isTossing,
                    tossSeed = state.tossSeed
                )
                AncientCoin(
                    value = state.currentCoinValues.second,
                    isTossing = state.isTossing,
                    tossSeed = state.tossSeed + 1
                )
                AncientCoin(
                    value = state.currentCoinValues.third,
                    isTossing = state.isTossing,
                    tossSeed = state.tossSeed + 2
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Last toss result info
            if (state.tosses.isNotEmpty()) {
                val last = state.tosses.last()
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Line ${last.lineIndex + 1}: ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Coins [${last.coinValues.first}+${last.coinValues.second}+${last.coinValues.third} = ${last.sum}] ➔ ${last.typeDescription}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (last.isChanging) BrightCinnabar else MaterialTheme.colorScheme.primary
                    )
                }
            } else {
                Text(
                    text = "Three coins produce Yin (2) or Yang (3). Sums 6 & 9 are changing lines.",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Live partial Hexagram Build Preview
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    .padding(12.dp)
            ) {
                val currentLines = state.tosses.map { it.isYang }
                val changingIndices = state.tosses.filter { it.isChanging }.map { it.lineIndex + 1 }

                // Pad up to 6 with placeholder for visualization
                val paddedLines = currentLines + List(6 - currentLines.size) { false }

                HexagramGlyph(
                    lines = paddedLines,
                    changingLineIndices = changingIndices,
                    lineHeight = 8.dp,
                    lineSpacing = 5.dp,
                    lineColor = if (currentLines.isNotEmpty()) MaterialTheme.colorScheme.primary else Color.Transparent,
                    changingColor = BrightCinnabar
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Primary Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onTossSingle,
                    enabled = !state.isTossing,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("toss_coins_button"),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (state.isTossing) "Tossing..." else "Toss Line $currentLineNumber",
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onQuickCast,
                    enabled = !state.isTossing,
                    modifier = Modifier.testTag("quick_cast_button"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Cast All")
                }
            }
        }
    }
}

@Composable
private fun DivinationResultView(
    state: DivinationUiState,
    onSave: () -> Unit,
    onNotesChange: (String) -> Unit,
    onReset: () -> Unit
) {
    val primary = state.primaryHexagram ?: return
    val transformed = state.transformedHexagram
    val changingIndices = state.changingLineIndices

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Oracle Banner
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(ImperialGold)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "DIVINATION REVEALED",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(ImperialGold)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Hexagram Cards: Primary and Transformed (Relating)
        if (transformed != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Primary Hexagram Card
                HexagramSummaryCard(
                    titleTag = "PRIMARY HEXAGRAM",
                    hexagram = primary,
                    changingIndices = changingIndices,
                    modifier = Modifier.weight(1f)
                )

                // Transformed Hexagram Card
                HexagramSummaryCard(
                    titleTag = "TRANSFORMED HEXAGRAM",
                    hexagram = transformed,
                    changingIndices = emptyList(),
                    modifier = Modifier.weight(1f)
                )
            }
        } else {
            // Single Hexagram (no changing lines)
            HexagramSummaryCard(
                titleTag = "PRIMARY HEXAGRAM (UNSTIRRED)",
                hexagram = primary,
                changingIndices = emptyList(),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Changing Lines Wisdom Section (if any lines changed)
        if (changingIndices.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                border = androidx.compose.foundation.BorderStroke(1.dp, BrightCinnabar.copy(alpha = 0.4f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(BrightCinnabar)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Changing Lines Guidance (爻辭)",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = BrightCinnabar
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Lines in motion represent the active dynamic forces shifting your situation:",
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    changingIndices.forEach { lineIndex ->
                        val lineText = primary.lineTexts.getOrElse(lineIndex - 1) { "" }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = lineText,
                                    fontSize = 13.sp,
                                    lineHeight = 18.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Primary Judgment Card
        ResultDetailCard(
            title = "The Judgment (彖辭 / 卦辭)",
            content = primary.judgment,
            accentColor = ImperialGold
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Primary Image Card
        ResultDetailCard(
            title = "The Image (象辭)",
            content = primary.theImage,
            accentColor = MaterialTheme.colorScheme.tertiary
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Commentary / Meaning Card
        ResultDetailCard(
            title = "Situational Insight",
            content = primary.commentary,
            accentColor = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Reflection Notes & Save to Journal
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "Personal Reflection / Journal Notes",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = state.reflectionNotes,
                    onValueChange = onNotesChange,
                    placeholder = { Text("Record your thoughts, emotions, or intuitions on this oracle reading...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("reflection_notes_input"),
                    singleLine = false,
                    maxLines = 4,
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = onSave,
                        enabled = !state.isSaved,
                        modifier = Modifier
                            .weight(1f)
                            .testTag("save_journal_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (state.isSaved) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = if (state.isSaved) Icons.Default.Check else Icons.Default.Save,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = if (state.isSaved) "Saved to Journal" else "Save Reading")
                    }

                    OutlinedButton(
                        onClick = onReset,
                        modifier = Modifier.testTag("new_cast_button"),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("New Cast")
                    }
                }
            }
        }
    }
}

@Composable
private fun HexagramSummaryCard(
    titleTag: String,
    hexagram: Hexagram,
    changingIndices: List<Int>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = titleTag,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Glyph
            Box(
                modifier = Modifier
                    .width(96.dp)
                    .padding(vertical = 4.dp)
            ) {
                HexagramGlyph(
                    lines = hexagram.lines,
                    changingLineIndices = changingIndices,
                    lineHeight = 7.dp,
                    lineSpacing = 4.dp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "${hexagram.number}. ",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = hexagram.chinese,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = hexagram.pinyin,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = hexagram.englishName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${hexagram.upperTrigram.symbol} ${hexagram.upperTrigram.englishName} / ${hexagram.lowerTrigram.symbol} ${hexagram.lowerTrigram.englishName}",
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ResultDetailCard(
    title: String,
    content: String,
    accentColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(4.dp, 16.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(accentColor)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                fontSize = 13.5.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
