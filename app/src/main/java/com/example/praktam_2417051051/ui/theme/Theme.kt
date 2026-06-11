package com.example.praktam_2417051051.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.Color

private val ThryveColors = lightColorScheme(
    primary = PrimaryPurple,
    onPrimary = White,
    primaryContainer = SoftPurple,
    onPrimaryContainer = DarkPurple,
    background = Color(0xFFF8F5FC),
    surface = White,
    onBackground = Color(0xFF1F1235),
    onSurface = Color(0xFF1F1235),
    secondary = PrimaryPurple,
    onSecondary = White,
    surfaceVariant = LightPurple,
    onSurfaceVariant = DarkPurple
)

@Composable
fun ThryveTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ThryveColors,
        typography = Typography,
        content = content
    )
}