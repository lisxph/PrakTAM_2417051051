package com.example.praktam_2417051051.Homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
fun HomePage() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .background(Color.White)
        ) {
            WelcomeCard()
            Spacer(modifier = Modifier.height(16.dp))
            ToDoListCard()
            Spacer(modifier = Modifier.height(16.dp))
            MoodTrackerCard()
        }
    }
}

@Composable
fun WelcomeCard() {
    Card(
        modifier = Modifier.fillMaxWidth().height(180.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5C6C6))
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hi, Kumi!", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
                Text(text = "Start your day with drink water!", color = Color.Gray)
            }
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ToDoListCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFC9E09D))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "To-Do List", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
                Text(text = "What are you gonna do today?", color = Color.Gray)
            }
            Image(
                painter = painterResource(id = R.drawable.todo),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun MoodTrackerCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFC9E09D))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Mood Tracker", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
                Text(text = "How do you feel today?", color = Color.Gray)
            }
            Image(
                painter = painterResource(id = R.drawable.moood),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        containerColor = Color(0xFFC9E09D),
        contentColor = Color.Black,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.task),
                    contentDescription = "Task",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.mood),
                    contentDescription = "Mood",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Setting",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    PrakTAM_2417051051Theme {
        HomePage()
    }
}
