package com.example.praktam_2417051051.data.model

import com.google.gson.annotations.SerializedName

data class Journal(
    @SerializedName("title")
    val title: String,
    
    @SerializedName("desc")
    val desc: String,

    @SerializedName("image_url")
    val imageUrl: String = ""
)
