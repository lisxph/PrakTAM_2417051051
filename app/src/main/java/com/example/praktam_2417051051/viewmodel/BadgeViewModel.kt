package com.example.praktam_2417051051.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.praktam_2417051051.data.model.Badge

class BadgeViewModel : ViewModel() {

    val badgeList = mutableStateListOf(
        Badge("First Step", "Complete sign up", true),
        Badge("Consistent", "Track mood 3 times", false),
        Badge("Mood Explorer", "Track mood 5 times", false),
        Badge("Journaler", "Write 3 journal entries", false),
        Badge("Task Master", "Complete 10 tasks", false),
        Badge("Self Love", "Write your first journal", false)
    )

    fun updateBadges(
        moodCount: Int,
        journalCount: Int,
        completedTask: Int
    ) {
        badgeList[1] = badgeList[1].copy(unlocked = moodCount >= 3)
        badgeList[2] = badgeList[2].copy(unlocked = moodCount >= 5)
        badgeList[3] = badgeList[3].copy(unlocked = journalCount >= 3)
        badgeList[4] = badgeList[4].copy(unlocked = completedTask >= 10)
        badgeList[5] = badgeList[5].copy(unlocked = journalCount >= 1)
    }
}