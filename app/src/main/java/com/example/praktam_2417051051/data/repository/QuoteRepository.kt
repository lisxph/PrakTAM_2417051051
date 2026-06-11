package com.example.praktam_2417051051.data.repository

import com.example.praktam_2417051051.data.api.RetrofitClient
import com.example.praktam_2417051051.data.model.Quote

class QuoteRepository {

    suspend fun getQuote(): List<Quote> {

        return RetrofitClient.api.getQuote()

    }
}