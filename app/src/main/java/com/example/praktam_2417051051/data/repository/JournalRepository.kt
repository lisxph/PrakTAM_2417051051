package com.example.praktam_2417051051.data.repository

import com.example.praktam_2417051051.data.network.RetrofitClient
import com.example.praktam_2417051051.data.model.Journal

object JournalRepository {

    suspend fun getJournals(): List<Journal> {
        return RetrofitClient.instance.getJournals()
    }
}