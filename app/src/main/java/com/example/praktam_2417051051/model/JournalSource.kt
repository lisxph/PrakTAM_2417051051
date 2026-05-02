package com.example.praktam_2417051051.model

import android.content.Context

object JournalSource {
    // Fungsi untuk mencari ID drawable berdasarkan nama file (String) dari API
    fun getResourceId(context: Context, imageName: String): Int {
        return context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }
}
