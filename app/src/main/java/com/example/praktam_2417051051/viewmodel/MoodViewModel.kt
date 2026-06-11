package com.example.praktam_2417051051.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.praktam_2417051051.data.model.Mood
import com.example.praktam_2417051051.data.repository.MoodRepository

class MoodViewModel : ViewModel() {

    private val repository =
        MoodRepository

    val moodList =
        mutableStateListOf<Mood>()

    init {

        moodList.addAll(
            repository.getMoods()
        )

    }

    fun addMood(
        emoji: String,
        mood: String,
        note: String,
        date: String
    ) {

        val moodData =
            Mood(
                emoji,
                mood,
                note,
                date
            )

        repository.addMood(
            moodData
        )

        val index = moodList.indexOfFirst { it.date == date }
        if (index != -1) {
            moodList[index] = moodData
        } else {
            moodList.add(moodData)
        }
    }

    fun getMoodByDate(date: String): Mood? {
        return repository.getMoodByDate(date)
    }

    fun totalMood(): Int {
        return moodList.size
    }
}