package com.example.praktam_2417051051.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MoodButton(
    emoji: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick
    ) {
        Text(emoji)
    }
}