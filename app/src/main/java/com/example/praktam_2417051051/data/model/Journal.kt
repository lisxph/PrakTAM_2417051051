package com.example.praktam_2417051051.data.model

data class Journal(
    val id: Int,
    val title: String,
    val content: String,
    val mood: String,
    val date: String,
    val isFavorite:Boolean = false
)
