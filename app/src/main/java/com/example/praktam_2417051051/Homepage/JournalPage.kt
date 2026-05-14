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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.praktam_2417051051.R
import com.example.praktam_2417051051.data.model.Journal
import com.example.praktam_2417051051.data.repository.JournalRepository

@Composable
fun JournalPage(
    onNavigateToHome: () -> Unit = {}
) {

    var journalList by remember {
        mutableStateOf<List<Journal>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var isError by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(Unit) {

        try {

            journalList = JournalRepository.getJournals()

            isLoading = false

        } catch (e: Exception) {

            isLoading = false
            isError = true
        }
    }

    Scaffold(
        bottomBar = {
            JournalBottomNavigationBar(
                onHomeClick = onNavigateToHome
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5EEFF))
        ) {

            if (isError) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Gagal Memuat Data",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Pastikan koneksi internet Anda menyala",
                        color = Color.Gray
                    )
                }

            } else {

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
            }

            FloatingActionButton(
                onClick = {

                    coroutineScope.launch {

                        isLoading = true

                        delay(2000)

                        val newJournal = Journal(
                            title = "Day ${journalList.size + 1}",
                            desc = "New journal added successfully!",
                            imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb"
                        )

                        journalList = journalList + newJournal

                        isLoading = false

                        snackbarHostState.showSnackbar(
                            "New journal created!"
                        )
                    }
                },

                containerColor = MaterialTheme.colorScheme.primary,

                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(x = 80.dp, y = (-40).dp)
            ) {

                Text(
                    text = "+",
                    fontSize = 28.sp,
                    color = Color.White
                )
            }

            if (isLoading) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {

                    CircularProgressIndicator(
                        color = Color(0xFFB388FF)
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                SnackbarHost(
                    hostState = snackbarHostState
                ) { data ->

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF616161)
                        ),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {

                        Text(
                            text = data.visuals.message,
                            modifier = Modifier.padding(
                                horizontal = 24.dp,
                                vertical = 16.dp
                            ),
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

    var isFavorite by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {

        Column {

            AsyncImage(
                model = journal.imageUrl,
                contentDescription = journal.title,

                placeholder = painterResource(id = R.drawable.journal),

                error = painterResource(id = R.drawable.journal),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),

                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Column {

                    Text(
                        text = journal.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = journal.desc,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                IconButton(
                    onClick = {
                        isFavorite = !isFavorite
                    },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {

                    Icon(
                        imageVector = if (isFavorite)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,

                        contentDescription = null,

                        tint = if (isFavorite)
                            MaterialTheme.colorScheme.error
                        else
                            MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
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

        Column {

            AsyncImage(
                model = journal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text(
                    text = journal.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = journal.desc,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black.copy(alpha = 0.7f),
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun JournalBottomNavigationBar(
    onHomeClick: () -> Unit
) {

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

                Image(
                    painterResource(id = R.drawable.icon_home),
                    null,
                    Modifier.size(24.dp)
                )
            }

            IconButton(onClick = { }) {

                Image(
                    painterResource(id = R.drawable.icon_todo),
                    null,
                    Modifier.size(24.dp)
                )
            }

            IconButton(onClick = { }) {

                Image(
                    painterResource(id = R.drawable.icon_mood),
                    null,
                    Modifier.size(24.dp)
                )
            }

            Surface(
                modifier = Modifier.size(52.dp),
                shape = CircleShape,
                color = Color.White
            ) {

                IconButton(onClick = { }) {

                    Image(
                        painterResource(id = R.drawable.icon_journal),
                        null,
                        Modifier.size(24.dp)
                    )
                }
            }

            IconButton(onClick = { }) {

                Image(
                    painterResource(id = R.drawable.icon_setting),
                    null,
                    Modifier.size(24.dp)
                )
            }
        }
    }
}