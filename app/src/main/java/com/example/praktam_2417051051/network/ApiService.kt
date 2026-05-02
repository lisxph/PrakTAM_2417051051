package com.example.praktam_2417051051.network

import com.example.praktam_2417051051.model.Journal
import retrofit2.http.GET

interface ApiService {
    @GET("journal.json") // Ganti dengan endpoint Gist Anda
    suspend fun getJournals(): List<Journal>
}
