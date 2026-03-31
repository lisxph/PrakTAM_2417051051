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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Text(
                    text = "My Journal",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            item {
                Text(
                    text = "Favorite Journals",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
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
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
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
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
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

@Composable
fun SmallJournalCard(journal: Journal) {
    Card(
        modifier = Modifier.width(140.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = journal.title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = journal.desc,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun JournalBottomNavigationBar(
    onHomeClick: () -> Unit
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
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
                color = MaterialTheme.colorScheme.surface
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