package com.example.praktam_2417051051.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.praktam_2417051051.ui.components.BadgeCard
import com.example.praktam_2417051051.ui.components.BottomBar
import com.example.praktam_2417051051.viewmodel.BadgeViewModel
import com.example.praktam_2417051051.viewmodel.TodoViewModel
import com.example.praktam_2417051051.viewmodel.MoodViewModel
import com.example.praktam_2417051051.viewmodel.JournalViewModel

@Composable
fun BadgeScreen(
    navController: NavController,
    vm: BadgeViewModel,
    todoVm: TodoViewModel,
    moodVm: MoodViewModel,
    journalVm: JournalViewModel
) {
    vm.updateBadges(
        moodCount = moodVm.totalMood(),
        journalCount = journalVm.totalJournal(),
        completedTask = todoVm.completedTaskCount()
    )

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(
                text = "My Badges",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            LazyColumn {

                items(vm.badgeList) { badge ->

                    BadgeCard(
                        badge = badge
                    )

                }
            }
        }
    }
}