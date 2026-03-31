package com.example.praktam_2417051051.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,
    secondary = PurpleSecondary,
    background = PurpleBackground,
    surface = White,
    onPrimary = White,
    onBackground = TextDark,
    onSurface = TextDark
)

@Composable
fun PrakTAM_2417051051Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}