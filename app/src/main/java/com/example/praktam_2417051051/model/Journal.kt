package com.example.praktam_2417051051.model

import com.google.gson.annotations.SerializedName

data class Journal(
    @SerializedName("title")
    val title: String,
    
    @SerializedName("desc")
    val desc: String,

    @SerializedName("image_url") // Mengubah dari image_name menjadi image_url sesuai tutorial Coil
    val imageUrl: String = ""
)
