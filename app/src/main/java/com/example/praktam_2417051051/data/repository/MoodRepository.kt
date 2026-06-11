package com.example.praktam_2417051051.data.repository

import com.example.praktam_2417051051.data.model.Mood

object MoodRepository {

    private val moods =
        mutableListOf<Mood>()

    fun getMoods(): List<Mood> {
        return moods
    }

    fun addMood(
        mood: Mood
    ) {
        val index = moods.indexOfFirst { it.date == mood.date }
        if (index != -1) {
            moods[index] = mood
        } else {
            moods.add(mood)
        }
    }

    fun getMoodByDate(date: String): Mood? {
        return moods.find { it.date == date }
    }
}