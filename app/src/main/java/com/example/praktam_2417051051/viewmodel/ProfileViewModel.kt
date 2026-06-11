package com.example.praktam_2417051051.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktam_2417051051.data.datastore.UserPreferences
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val prefs = UserPreferences(application)

    var name = mutableStateOf("Kumi")
    var email = mutableStateOf("kumi@gmail.com")

    init {
        viewModelScope.launch {
            prefs.userName.collect {
                name.value = it
            }
        }
        viewModelScope.launch {
            prefs.userEmail.collect {
                email.value = it
            }
        }
    }

    fun saveProfile() {
        viewModelScope.launch {
            prefs.saveProfile(name.value, email.value)
        }
    }
}