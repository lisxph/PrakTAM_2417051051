package com.example.praktam_2417051051.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktam_2417051051.data.model.Badge
import androidx.compose.ui.graphics.Color

@Composable
fun BadgeCard(
    badge: Badge
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        colors = CardDefaults.cardColors(

            containerColor =

                if (badge.unlocked)
                    Color(0xFFF4E8FF)
                else
                    Color.LightGray
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = if (badge.unlocked)
                    "🏆 ${badge.title}"
                else
                    "🔒 ${badge.title}",

                style =
                    MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = badge.description
            )
        }
    }
}