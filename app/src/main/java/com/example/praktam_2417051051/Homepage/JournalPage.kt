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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.praktam_2417051051.R
import com.example.praktam_2417051051.model.Journal
import com.example.praktam_2417051051.model.JournalData

@Composable
fun JournalPage(
    onNavigateToHome: () -> Unit = {}
) {

    var journalList by remember { mutableStateOf(JournalData.journals.toMutableList()) }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        bottomBar = {
            JournalBottomNavigationBar(onHomeClick = onNavigateToHome)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5EEFF))
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "My Journal",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFFB388FF),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Favorite Journals",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(journalList) { journal ->
                            SmallJournalCard(journal)
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

                items(journalList) { journal ->
                    JournalCard(journal)
                }
            }

            Button(
                onClick = {
                    coroutineScope.launch {
                        isLoading = true
                        delay(2000)

                        val newJournal = Journal(
                            title = "Day ${journalList.size + 1}",
                            desc = "New journal entry created successfully!"
                        )

                        journalList = (journalList + newJournal).toMutableList()
                        isLoading = false
                        snackbarHostState.showSnackbar("New journal created!")
                    }
                },
                enabled = !isLoading,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 20.dp)
                    .size(60.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB388FF),
                    disabledContainerColor = Color(0xFFB388FF).copy(alpha = 0.5f)
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("+", fontSize = 32.sp, color = Color.White)
            }

            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color(0xFFB388FF))
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                SnackbarHost(hostState = snackbarHostState) { data ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF616161)),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Text(
                            text = data.visuals.message,
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun JournalCard(journal: Journal) {
    var isFavorite by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD1B2FF)
        )
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = journal.title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = { isFavorite = !isFavorite }) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.White.copy(alpha = 0.4f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = journal.desc,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                lineHeight = 20.sp
            )
        }
    }
}

@Composable
fun SmallJournalCard(journal: Journal) {
    Card(
        modifier = Modifier.width(160.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEBD4FF)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = journal.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = journal.desc,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black.copy(alpha = 0.7f),
                maxLines = 1
            )
        }
    }
}

@Composable
fun JournalBottomNavigationBar(onHomeClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(64.dp)
            .clip(RoundedCornerShape(32.dp)),
        color = Color(0xFFD1B2FF)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onHomeClick) {
                Image(painterResource(id = R.drawable.icon_home), null, Modifier.size(24.dp))
            }
            IconButton(onClick = { }) {
                Image(painterResource(id = R.drawable.icon_todo), null, Modifier.size(24.dp))
            }
            IconButton(onClick = { }) {
                Image(painterResource(id = R.drawable.icon_mood), null, Modifier.size(24.dp))
            }
            // Active Item
            Surface(modifier = Modifier.size(52.dp), shape = CircleShape, color = Color.White) {
                IconButton(onClick = { }) {
                    Image(painterResource(id = R.drawable.icon_journal), null, Modifier.size(24.dp))
                }
            }
            IconButton(onClick = { }) {
                Image(painterResource(id = R.drawable.icon_setting), null, Modifier.size(24.dp))
            }
        }
    }
}