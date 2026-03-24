package com.example.praktam_2417051051.Homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.praktam_2417051051.model.Journal
import com.example.praktam_2417051051.model.JournalData

@Composable
fun JournalPage(
    onNavigateToHome: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            JournalBottomNavigationBar(onHomeClick = onNavigateToHome)
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF5EEFF)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Text(
                    text = "My Journal",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF9C27B0)
                )
            }

            item {
                Text(
                    text = "Favorite Journals",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(JournalData.journals) { journal ->
                        SmallJournalCard(journal)
                    }
                }
            }

            items(JournalData.journals) { journal ->
                JournalCard(journal)
            }
        }
    }
}

@Composable
fun JournalCard(journal: Journal) {
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
                    text = journal.title,
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
                    text = journal.desc,
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
                    contentDescription = null,
                    tint = if (isFavorite) Color.Red else Color.White
                )
            }
        }
    }
}

@Composable
fun SmallJournalCard(journal: Journal) {
    Card(
        modifier = Modifier.width(140.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBD4FF))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = journal.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = journal.desc,
                fontSize = 12.sp,
                maxLines = 2
            )
        }
    }
}

@Composable
fun JournalBottomNavigationBar(
    onHomeClick: () -> Unit
) {
    BottomAppBar(
        containerColor = Color(0xFFD1B2FF),
        modifier = Modifier.clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onHomeClick) {
                Image(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_todo),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_mood),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
            }
            Surface(
                modifier = Modifier.size(52.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_journal),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_setting),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}