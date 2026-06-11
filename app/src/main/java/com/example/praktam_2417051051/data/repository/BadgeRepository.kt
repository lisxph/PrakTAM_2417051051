package com.example.praktam_2417051051.data.repository

import com.example.praktam_2417051051.data.model.Badge

object BadgeRepository {

    val badges = mutableListOf(

        Badge(
            title = "First Step",
            description = "Login pertama",
            unlocked = true
        ),

        Badge(
            title = "Mood Explorer",
            description = "Isi mood 5 kali",
            unlocked = false
        ),

        Badge(
            title = "Journaler",
            description = "Buat 3 journal",
            unlocked = false
        ),

        Badge(
            title = "Task Master",
            description = "Selesaikan 10 task",
            unlocked = false
        ),

        Badge(
            title = "Consistency King",
            description = "Login 7 hari berturut-turut",
            unlocked = false
        )
    )
}