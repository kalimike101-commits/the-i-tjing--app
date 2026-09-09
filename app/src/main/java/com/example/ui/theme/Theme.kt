package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = ImperialGold,
    onPrimary = InkObsidian,
    primaryContainer = DeepGold,
    onPrimaryContainer = SoftGold,
    secondary = BrightCinnabar,
    onSecondary = Color.White,
    secondaryContainer = MutedCinnabar,
    onSecondaryContainer = Color(0xFFFFDAD4),
    tertiary = JadeSage,
    onTertiary = InkObsidian,
    tertiaryContainer = DeepJade,
    onTertiaryContainer = Color(0xFFBCE3C3),
    background = InkObsidian,
    onBackground = InkTextPrimary,
    surface = InkDarkSurface,
    onSurface = InkTextPrimary,
    surfaceVariant = InkCardBg,
    onSurfaceVariant = InkTextSecondary,
    outline = InkBorder,
    outlineVariant = Color(0xFF2C2722)
)

private val LightColorScheme = lightColorScheme(
    primary = WarmBronze,
    onPrimary = Color.White,
    primaryContainer = SoftGold,
    onPrimaryContainer = Color(0xFF2E1F03),
    secondary = CinnabarRed,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFDAD4),
    onSecondaryContainer = MutedCinnabar,
    tertiary = DeepJade,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFBCE3C3),
    onTertiaryContainer = Color(0xFF0F3818),
    background = ParchmentBg,
    onBackground = CalligraphyInk,
    surface = ParchmentSurface,
    onSurface = CalligraphyInk,
    surfaceVariant = ParchmentCard,
    onSurfaceVariant = CalligraphySecondary,
    outline = ParchmentBorder,
    outlineVariant = Color(0xFFDDD2C2)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Use our authentic I-Ching ink and gold aesthetic
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
