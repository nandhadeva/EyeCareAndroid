package com.viswa2k.eyecare.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlin.math.max
import kotlin.math.min

/**
 * Generates Material3-compatible color variants from a single base color.
 */
data class GeneratedColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color
)

fun generateLightScheme(base: Color): GeneratedColorScheme {
    val hsl = colorToHsl(base)
    return GeneratedColorScheme(
        primary = base,
        onPrimary = Color.White,
        primaryContainer = hslToColor(hsl[0], hsl[1] * 0.6f, 0.90f),
        onPrimaryContainer = hslToColor(hsl[0], hsl[1], 0.15f)
    )
}

fun generateDarkScheme(base: Color): GeneratedColorScheme {
    val hsl = colorToHsl(base)
    return GeneratedColorScheme(
        primary = hslToColor(hsl[0], hsl[1] * 0.7f, 0.75f),
        onPrimary = hslToColor(hsl[0], hsl[1], 0.15f),
        primaryContainer = hslToColor(hsl[0], hsl[1] * 0.8f, 0.25f),
        onPrimaryContainer = hslToColor(hsl[0], hsl[1] * 0.6f, 0.90f)
    )
}

fun hexToColor(hex: String): Color? {
    return try {
        val cleaned = hex.removePrefix("#")
        if (cleaned.length == 6) {
            Color(0xFF000000 or cleaned.toLong(16))
        } else null
    } catch (_: Exception) {
        null
    }
}

fun colorToHex(color: Color): String {
    val argb = color.toArgb()
    return String.format("%06X", argb and 0xFFFFFF)
}

private fun colorToHsl(color: Color): FloatArray {
    val r = color.red
    val g = color.green
    val b = color.blue
    val max = max(r, max(g, b))
    val min = min(r, min(g, b))
    val l = (max + min) / 2f
    if (max == min) return floatArrayOf(0f, 0f, l)
    val d = max - min
    val s = if (l > 0.5f) d / (2f - max - min) else d / (max + min)
    val h = when (max) {
        r -> ((g - b) / d + (if (g < b) 6f else 0f)) / 6f
        g -> ((b - r) / d + 2f) / 6f
        else -> ((r - g) / d + 4f) / 6f
    }
    return floatArrayOf(h, s, l)
}

private fun hslToColor(h: Float, s: Float, l: Float): Color {
    val sc = s.coerceIn(0f, 1f)
    val lc = l.coerceIn(0f, 1f)
    if (sc == 0f) return Color(lc, lc, lc)
    val q = if (lc < 0.5f) lc * (1f + sc) else lc + sc - lc * sc
    val p = 2f * lc - q
    return Color(
        red = hueToRgb(p, q, h + 1f / 3f),
        green = hueToRgb(p, q, h),
        blue = hueToRgb(p, q, h - 1f / 3f)
    )
}

private fun hueToRgb(p: Float, q: Float, t: Float): Float {
    var tt = t
    if (tt < 0f) tt += 1f
    if (tt > 1f) tt -= 1f
    return when {
        tt < 1f / 6f -> p + (q - p) * 6f * tt
        tt < 1f / 2f -> q
        tt < 2f / 3f -> p + (q - p) * (2f / 3f - tt) * 6f
        else -> p
    }
}
