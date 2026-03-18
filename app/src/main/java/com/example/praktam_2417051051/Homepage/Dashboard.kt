package com.example.praktam_2417051051.Homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktam_2417051051.R
import com.example.praktam_2417051051.ui.theme.PrakTAM_2417051051Theme

@Composable
fun Dashboard(
    onNavigateToJournal: () -> Unit = {},
    onNavigateToHome: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = { 
            DashboardBottomNavigationBar(
                onHomeClick = onNavigateToHome,
                onJournalClick = onNavigateToJournal
            ) 
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState)
        ) {
            DashboardWelcomeCard(modifier = Modifier.padding(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color(0xFFF5EEFF))
                    .padding(16.dp)
            ) {
                DashboardTaskCard()
                Spacer(modifier = Modifier.height(16.dp))
                
                DashboardFeatureCard(
                    title = "To-Do List",
                    description = "What are you gonna do today?",
                    buttonText = "List Here",
                    imageRes = R.drawable.todo,
                    onButtonClick = {  }
                )
                Spacer(modifier = Modifier.height(16.dp))

                DashboardFeatureCard(
                    title = "Mood Tracker",
                    description = "How do you feel today?",
                    buttonText = "Track Mood",
                    imageRes = R.drawable.mood,
                    onButtonClick = {  }
                )
                Spacer(modifier = Modifier.height(16.dp))

                DashboardFeatureCard(
                    title = "Journal",
                    description = "What's on your mind?",
                    buttonText = "Write Here",
                    imageRes = R.drawable.journal,
                    onButtonClick = onNavigateToJournal
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun DashboardWelcomeCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD1B2FF))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.TopStart)
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White,
                    shadowElevation = 4.dp
                ) {
                    Text(
                        text = "Hi, Kumi!",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Start your\nday with\nwater!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.White,
                    lineHeight = 32.sp
                )
            }
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 10.dp, y = 10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun DashboardTaskCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBD4FF))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(54.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_coffe),
                    contentDescription = null,
                    modifier = Modifier.padding(12.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Tasks: 3 left", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
                Text(text = "0 Complete", fontSize = 14.sp, color = Color.DarkGray)
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun DashboardFeatureCard(
    title: String,
    description: String,
    buttonText: String,
    imageRes: Int,
    onButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBD4FF))
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.Black)
                Text(text = description, fontSize = 14.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.height(44.dp)
                ) {
                    Text(text = buttonText, color = Color(0xFF9C27B0), fontWeight = FontWeight.Bold)
                }
            }
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.size(130.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun DashboardBottomNavigationBar(
    onHomeClick: () -> Unit,
    onJournalClick: () -> Unit
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
            Surface(
                modifier = Modifier.size(52.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                IconButton(onClick = onHomeClick) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_home),
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp)
                    )
                }
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
            IconButton(onClick = onJournalClick) {
                Image(
                    painter = painterResource(id = R.drawable.icon_journal),
                    contentDescription = "Journal",
                    modifier = Modifier.size(26.dp)
                )
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

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    PrakTAM_2417051051Theme {
        Dashboard()
    }
}
