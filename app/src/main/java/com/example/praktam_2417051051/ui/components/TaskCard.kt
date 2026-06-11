package com.example.praktam_2417051051.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktam_2417051051.data.model.Task

@Composable
fun TaskCard(
    task: Task,
    onChecked: () -> Unit,
    onClick: () -> Unit
) {
    val categoryColor = when (task.category) {
        "Daily habit" -> Color(0xFFF3E8FF)
        "Self-care" -> Color(0xFFFCE7F3)
        "Health" -> Color(0xFFFEE2E2)
        "Personal growth" -> Color(0xFFECFDF5)
        "Work" -> Color(0xFFFEF3C7)
        else -> Color(0xFFE0F2FE)
    }
    
    val categoryTextColor = when (task.category) {
        "Daily habit" -> Color(0xFF6B21A8)
        "Self-care" -> Color(0xFFBE185D)
        "Health" -> Color(0xFFB91C1C)
        "Personal growth" -> Color(0xFF047857)
        "Work" -> Color(0xFFB45309)
        else -> Color(0xFF0369A1)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = if (task.completed) MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f) else MaterialTheme.colorScheme.onBackground,
                        textDecoration = if (task.completed) TextDecoration.LineThrough else TextDecoration.None
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(categoryColor)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = task.category,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 10.sp,
                            color = categoryTextColor
                        )
                    )
                }
            }

            Checkbox(
                checked = task.completed,
                onCheckedChange = { onChecked() },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                ),
                modifier = Modifier.clip(CircleShape)
            )
        }
    }
}