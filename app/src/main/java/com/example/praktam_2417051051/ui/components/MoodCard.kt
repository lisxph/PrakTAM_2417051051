package com.example.praktam_2417051051.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktam_2417051051.data.model.Mood

@Composable
fun MoodCard(
    mood: Mood
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "${mood.emoji} ${mood.mood}",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(mood.note)

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = mood.date,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}