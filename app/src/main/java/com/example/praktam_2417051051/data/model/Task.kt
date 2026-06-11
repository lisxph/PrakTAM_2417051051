package com.example.praktam_2417051051.data.model

data class Task(
    val id:Int,
    val title:String,
    val category:String,
    var completed:Boolean=false
)