package com.example.praktam_2417051051.data.api

import com.example.praktam_2417051051.data.model.Quote
import retrofit2.http.GET

interface QuoteApi {

    @GET("random")
    suspend fun getQuote(): List<Quote>

}