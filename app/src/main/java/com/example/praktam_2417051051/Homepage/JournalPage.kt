package com.example.praktam_2417051051.Homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktam_2417051051.R

@Composable
fun JournalPage(
    onNavigateToHome: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = { 
            JournalBottomNavigationBar(onHomeClick = onNavigateToHome) 
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF5EEFF))
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Text(
                text = "My Journal",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9C27B0),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            repeat(5) {
                JournalCard()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun JournalCard() {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD1B2FF))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = "Journal Entry",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(
                    color = Color.White.copy(alpha = 0.6f),
                    thickness = 1.dp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hari ini adalah hari yang produktif. Saya belajar banyak hal baru tentang pengembangan Android menggunakan Jetpack Compose...",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }

            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color.Red else Color.White
                )
            }
        }
    }
}

@Composable
fun JournalBottomNavigationBar(
    onHomeClick: () -> Unit
) {
    BottomAppBar(
        containerColor = Color(0xFFD1B2FF),
        contentColor = Color.Black,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
        tonalElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onHomeClick) {
                Image(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(26.dp)
                )
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_todo),
                    contentDescription = "To-Do",
                    modifier = Modifier.size(26.dp)
                )
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_mood),
                    contentDescription = "Mood",
                    modifier = Modifier.size(26.dp)
                )
            }
            // Journal icon selected in JournalPage
            Surface(
                modifier = Modifier.size(52.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_journal),
                        contentDescription = "Journal",
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_setting),
                    contentDescription = "Settings",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}
