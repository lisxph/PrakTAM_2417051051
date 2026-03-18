package com.example.praktam_2417051051.model

import androidx.annotation.DrawableRes

data class Feature(
    val title: String,
    val description: String,
    val buttonText: String,
    @DrawableRes val imageRes: Int
)