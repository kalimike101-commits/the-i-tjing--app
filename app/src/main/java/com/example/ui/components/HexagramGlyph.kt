package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.BrightCinnabar
import com.example.ui.theme.CinnabarRed
import com.example.ui.theme.ImperialGold

/**
 * Draws a single I-Ching line:
 * - Solid Yang line: ⚊
 * - Broken Yin line: ⚋ (split in two equal halves with gap in middle)
 * If changing:
 * - Old Yin (6): Broken line marked with '✕' or Cinnabar accent
 * - Old Yang (9): Solid line marked with '⚪' or Cinnabar accent
 */
@Composable
fun HexagramLine(
    isYang: Boolean,
    isChanging: Boolean = false,
    height: Dp = 12.dp,
    modifier: Modifier = Modifier,
    lineColor: Color = MaterialTheme.colorScheme.primary,
    changingColor: Color = CinnabarRed
) {
    val activeColor by animateColorAsState(
        targetValue = if (isChanging) changingColor else lineColor,
        animationSpec = tween(400),
        label = "lineColor"
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        val strokeH = size.height
        val totalW = size.width
        val cornerRadius = CornerRadius(strokeH / 3, strokeH / 3)

        if (isYang) {
            // Solid Yang Line
            drawRoundRect(
                color = activeColor,
                topLeft = Offset(0f, 0f),
                size = Size(totalW, strokeH),
                cornerRadius = cornerRadius
            )
            if (isChanging) {
                // Draw circle in center (Old Yang marker ⚪)
                val circleR = strokeH * 0.45f
                drawCircle(
                    color = Color.White,
                    radius = circleR,
                    center = Offset(totalW / 2f, strokeH / 2f)
                )
                drawCircle(
                    color = activeColor,
                    radius = circleR * 0.6f,
                    center = Offset(totalW / 2f, strokeH / 2f)
                )
            }
        } else {
            // Broken Yin Line (2 segments with center gap)
            val gapRatio = 0.18f
            val segmentW = (totalW * (1f - gapRatio)) / 2f
            val gapW = totalW * gapRatio

            // Left segment
            drawRoundRect(
                color = activeColor,
                topLeft = Offset(0f, 0f),
                size = Size(segmentW, strokeH),
                cornerRadius = cornerRadius
            )
            // Right segment
            drawRoundRect(
                color = activeColor,
                topLeft = Offset(segmentW + gapW, 0f),
                size = Size(segmentW, strokeH),
                cornerRadius = cornerRadius
            )
            if (isChanging) {
                // Draw 'X' in the center gap (Old Yin marker ✕)
                val centerX = totalW / 2f
                val centerY = strokeH / 2f
                val arm = strokeH * 0.38f
                drawLine(
                    color = activeColor,
                    start = Offset(centerX - arm, centerY - arm),
                    end = Offset(centerX + arm, centerY + arm),
                    strokeWidth = 3f
                )
                drawLine(
                    color = activeColor,
                    start = Offset(centerX + arm, centerY - arm),
                    end = Offset(centerX - arm, centerY + arm),
                    strokeWidth = 3f
                )
            }
        }
    }
}

/**
 * Renders the full 6 lines of a Hexagram from top to bottom (Line 6 down to Line 1).
 * In traditional I-Ching, line 1 is bottom, line 6 is top.
 * Parameter [lines]: List of 6 booleans where index 0 = Line 1 (bottom), index 5 = Line 6 (top).
 */
@Composable
fun HexagramGlyph(
    lines: List<Boolean>,
    changingLineIndices: List<Int> = emptyList(), // 1-based indices (1 to 6)
    modifier: Modifier = Modifier,
    lineHeight: Dp = 10.dp,
    lineSpacing: Dp = 6.dp,
    showLabels: Boolean = false,
    lineColor: Color = MaterialTheme.colorScheme.primary,
    changingColor: Color = BrightCinnabar
) {
    val traditionalLabels = listOf("初 (1)", "二 (2)", "三 (3)", "四 (4)", "五 (5)", "上 (6)")

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(lineSpacing)
    ) {
        // Render from Line 6 (index 5) down to Line 1 (index 0)
        for (i in 5 downTo 0) {
            val isYang = lines.getOrElse(i) { true }
            val lineNum = i + 1
            val isChanging = changingLineIndices.contains(lineNum)

            if (showLabels) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = traditionalLabels[i],
                        fontSize = 11.sp,
                        fontWeight = if (isChanging) FontWeight.Bold else FontWeight.Normal,
                        color = if (isChanging) changingColor else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                        modifier = Modifier.width(38.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    HexagramLine(
                        isYang = isYang,
                        isChanging = isChanging,
                        height = lineHeight,
                        lineColor = lineColor,
                        changingColor = changingColor,
                        modifier = Modifier.weight(1f)
                    )
                    if (isChanging) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(changingColor)
                        )
                    } else {
                        Spacer(modifier = Modifier.width(14.dp))
                    }
                }
            } else {
                HexagramLine(
                    isYang = isYang,
                    isChanging = isChanging,
                    height = lineHeight,
                    lineColor = lineColor,
                    changingColor = changingColor
                )
            }
        }
    }
}
