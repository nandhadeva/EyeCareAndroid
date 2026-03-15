package com.viswa2k.eyecare.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

enum class ThemeMode(val displayName: String) {
    SYSTEM("System"),
    LIGHT("Light"),
    DARK("Dark")
}

private fun buildDarkScheme(primary: Color, secondary: Color) : androidx.compose.material3.ColorScheme {
    val p = generateDarkScheme(primary)
    val s = generateDarkScheme(secondary)
    return darkColorScheme(
        primary = p.primary,
        onPrimary = p.onPrimary,
        primaryContainer = p.primaryContainer,
        onPrimaryContainer = p.onPrimaryContainer,
        secondary = s.primary,
        onSecondary = s.onPrimary,
        secondaryContainer = s.primaryContainer,
        onSecondaryContainer = s.onPrimaryContainer,
        background = DarkBackground,
        onBackground = DarkOnBackground,
        surface = DarkSurface,
        onSurface = DarkOnSurface,
        surfaceVariant = DarkSurfaceVariant,
        onSurfaceVariant = DarkOnSurfaceVariant,
        error = DarkError,
        onError = DarkOnError
    )
}

private fun buildLightScheme(primary: Color, secondary: Color) : androidx.compose.material3.ColorScheme {
    val p = generateLightScheme(primary)
    val s = generateLightScheme(secondary)
    return lightColorScheme(
        primary = p.primary,
        onPrimary = p.onPrimary,
        primaryContainer = p.primaryContainer,
        onPrimaryContainer = p.onPrimaryContainer,
        secondary = s.primary,
        onSecondary = s.onPrimary,
        secondaryContainer = s.primaryContainer,
        onSecondaryContainer = s.onPrimaryContainer,
        background = LightBackground,
        onBackground = LightOnBackground,
        surface = LightSurface,
        onSurface = LightOnSurface,
        surfaceVariant = LightSurfaceVariant,
        onSurfaceVariant = LightOnSurfaceVariant,
        error = LightError,
        onError = LightOnError
    )
}

@Composable
fun EyeCareTheme(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    primaryColor: Color = AccentColor.TEAL.lightPrimary,
    secondaryColor: Color = AccentColor.GREEN.lightPrimary,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }
    val colorScheme = if (darkTheme) buildDarkScheme(primaryColor, secondaryColor)
                      else buildLightScheme(primaryColor, secondaryColor)
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
