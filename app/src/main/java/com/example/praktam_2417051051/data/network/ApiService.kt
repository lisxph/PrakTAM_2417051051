package com.example.praktam_2417051051.data.network

import com.example.praktam_2417051051.data.model.Journal
import retrofit2.http.GET

interface ApiService {
    @GET("journals.json")
    suspend fun getJournals(): List<Journal>
}
