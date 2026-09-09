package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.DeepGold
import com.example.ui.theme.ImperialGold
import com.example.ui.theme.SoftGold
import com.example.ui.theme.WarmBronze

/**
 * Traditional Chinese Coin (銅錢):
 * - Value 3 = Heads (Yang / 乾)
 * - Value 2 = Tails (Yin / 坤)
 */
@Composable
fun AncientCoin(
    value: Int, // 3 (Heads/Yang) or 2 (Tails/Yin)
    isTossing: Boolean = false,
    tossSeed: Long = 0L,
    size: Dp = 68.dp,
    modifier: Modifier = Modifier
) {
    val isYang = value == 3
    val rotation = remember { Animatable(0f) }
    val scale = remember { Animatable(1f) }

    LaunchedEffect(tossSeed) {
        if (tossSeed > 0L) {
            // Animate spin when tossed
            rotation.snapTo(0f)
            scale.snapTo(0.85f)
            rotation.animateTo(
                targetValue = 1080f + if (isYang) 0f else 180f,
                animationSpec = tween(durationMillis = 650, easing = FastOutSlowInEasing)
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 200)
            )
        }
    }

    val bronzeBorder = Brush.sweepGradient(
        listOf(
            ImperialGold,
            WarmBronze,
            SoftGold,
            DeepGold,
            ImperialGold
        )
    )

    val coinBodyGradient = Brush.radialGradient(
        colors = listOf(
            SoftGold,
            ImperialGold,
            WarmBronze,
            DeepGold
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .graphicsLayer {
                rotationY = rotation.value
                scaleX = scale.value
                scaleY = scale.value
                cameraDistance = 12 * density
            }
            .shadow(elevation = 6.dp, shape = CircleShape)
            .clip(CircleShape)
            .background(coinBodyGradient)
            .border(2.dp, bronzeBorder, CircleShape)
    ) {
        // Outer concentric ring & ancient coin rim
        Canvas(modifier = Modifier.matchParentSize()) {
            val r = this.size.minDimension / 2f
            val c = Offset(r, r)

            // Inner bevel rim
            drawCircle(
                color = WarmBronze.copy(alpha = 0.6f),
                radius = r * 0.88f,
                center = c,
                style = Stroke(width = 1.5f)
            )
            drawCircle(
                color = SoftGold.copy(alpha = 0.5f),
                radius = r * 0.85f,
                center = c,
                style = Stroke(width = 1.2f)
            )
        }

        // Square hole in the center (天圓地方 - Round Heaven, Square Earth)
        val holeSize = size * 0.28f
        Box(
            modifier = Modifier
                .size(holeSize)
                .clip(RoundedCornerShape(2.dp))
                .background(Color(0xFF181512))
                .border(1.dp, WarmBronze, RoundedCornerShape(2.dp))
        )

        // Ancient Coin Inscriptions (North, South, East, West)
        // Heads (Yang, value 3): 乾 (Top), 陽 (Bottom), 通 (Right), 寶 (Left)
        // Tails (Yin, value 2): 坤 (Top), 陰 (Bottom), 吉 (Right), 祥 (Left)
        val topChar = if (isYang) "乾" else "坤"
        val bottomChar = if (isYang) "陽" else "陰"

        // Top Character
        Text(
            text = topChar,
            fontSize = (size.value * 0.17f).sp,
            fontWeight = FontWeight.Bold,
            color = DeepGold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .graphicsLayer { translationY = (size.value * 0.12f) }
        )

        // Bottom Character
        Text(
            text = bottomChar,
            fontSize = (size.value * 0.17f).sp,
            fontWeight = FontWeight.Bold,
            color = DeepGold,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .graphicsLayer { translationY = -(size.value * 0.12f) }
        )
    }
}
