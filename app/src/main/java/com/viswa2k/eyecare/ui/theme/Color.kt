package com.viswa2k.eyecare.ui.theme

import androidx.compose.ui.graphics.Color

// Accent color presets
enum class AccentColor(
    val displayName: String,
    val lightPrimary: Color,
    val lightPrimaryContainer: Color,
    val lightOnPrimaryContainer: Color,
    val darkPrimary: Color,
    val darkPrimaryContainer: Color,
    val darkOnPrimaryContainer: Color
) {
    TEAL(
        displayName = "Teal",
        lightPrimary = Color(0xFF2E7D6F),
        lightPrimaryContainer = Color(0xFFB2DFDB),
        lightOnPrimaryContainer = Color(0xFF00332C),
        darkPrimary = Color(0xFF80CBC4),
        darkPrimaryContainer = Color(0xFF1B5E53),
        darkOnPrimaryContainer = Color(0xFFB2DFDB)
    ),
    BLUE(
        displayName = "Blue",
        lightPrimary = Color(0xFF1565C0),
        lightPrimaryContainer = Color(0xFFBBDEFB),
        lightOnPrimaryContainer = Color(0xFF002171),
        darkPrimary = Color(0xFF90CAF9),
        darkPrimaryContainer = Color(0xFF0D47A1),
        darkOnPrimaryContainer = Color(0xFFBBDEFB)
    ),
    PURPLE(
        displayName = "Purple",
        lightPrimary = Color(0xFF7B1FA2),
        lightPrimaryContainer = Color(0xFFE1BEE7),
        lightOnPrimaryContainer = Color(0xFF38006B),
        darkPrimary = Color(0xFFCE93D8),
        darkPrimaryContainer = Color(0xFF6A1B9A),
        darkOnPrimaryContainer = Color(0xFFE1BEE7)
    ),
    GREEN(
        displayName = "Green",
        lightPrimary = Color(0xFF2E7D32),
        lightPrimaryContainer = Color(0xFFC8E6C9),
        lightOnPrimaryContainer = Color(0xFF003300),
        darkPrimary = Color(0xFFA5D6A7),
        darkPrimaryContainer = Color(0xFF1B5E20),
        darkOnPrimaryContainer = Color(0xFFC8E6C9)
    ),
    ORANGE(
        displayName = "Orange",
        lightPrimary = Color(0xFFE65100),
        lightPrimaryContainer = Color(0xFFFFCCBC),
        lightOnPrimaryContainer = Color(0xFF5D2100),
        darkPrimary = Color(0xFFFFAB91),
        darkPrimaryContainer = Color(0xFFBF360C),
        darkOnPrimaryContainer = Color(0xFFFFCCBC)
    ),
    PINK(
        displayName = "Pink",
        lightPrimary = Color(0xFFC2185B),
        lightPrimaryContainer = Color(0xFFF8BBD0),
        lightOnPrimaryContainer = Color(0xFF560027),
        darkPrimary = Color(0xFFF48FB1),
        darkPrimaryContainer = Color(0xFF880E4F),
        darkOnPrimaryContainer = Color(0xFFF8BBD0)
    )
}

// Light theme colors - soft, eye-friendly palette
val LightPrimary = Color(0xFF2E7D6F)        // Soft teal
val LightOnPrimary = Color(0xFFFFFFFF)
val LightPrimaryContainer = Color(0xFFB2DFDB) // Light teal
val LightOnPrimaryContainer = Color(0xFF00332C)
val LightSecondary = Color(0xFF4A7C6B)       // Muted green
val LightOnSecondary = Color(0xFFFFFFFF)
val LightSecondaryContainer = Color(0xFFCDE8DC)
val LightOnSecondaryContainer = Color(0xFF06201A)
val LightBackground = Color(0xFFF5FAF7)      // Very light mint
val LightOnBackground = Color(0xFF1A1C1B)
val LightSurface = Color(0xFFF5FAF7)
val LightOnSurface = Color(0xFF1A1C1B)
val LightSurfaceVariant = Color(0xFFDBE5DF)
val LightOnSurfaceVariant = Color(0xFF3F4944)
val LightError = Color(0xFFBA1A1A)
val LightOnError = Color(0xFFFFFFFF)

// Dark theme colors - low contrast, easy on the eyes
val DarkPrimary = Color(0xFF80CBC4)          // Soft teal
val DarkOnPrimary = Color(0xFF003731)
val DarkPrimaryContainer = Color(0xFF1B5E53)
val DarkOnPrimaryContainer = Color(0xFFB2DFDB)
val DarkSecondary = Color(0xFFA5D6C1)        // Soft green
val DarkOnSecondary = Color(0xFF0B3628)
val DarkSecondaryContainer = Color(0xFF325B4A)
val DarkOnSecondaryContainer = Color(0xFFCDE8DC)
val DarkBackground = Color(0xFF1A1C1B)       // Very dark, low blue light
val DarkOnBackground = Color(0xFFE1E3E0)
val DarkSurface = Color(0xFF1A1C1B)
val DarkOnSurface = Color(0xFFE1E3E0)
val DarkSurfaceVariant = Color(0xFF3F4944)
val DarkOnSurfaceVariant = Color(0xFFBFC9C2)
val DarkError = Color(0xFFFFB4AB)
val DarkOnError = Color(0xFF690005)
