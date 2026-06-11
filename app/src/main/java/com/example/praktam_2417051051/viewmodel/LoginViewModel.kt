package com.example.praktam_2417051051.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktam_2417051051.data.datastore.UserPreferences
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val prefs =
        UserPreferences(application)

    fun login(email: String) {
        viewModelScope.launch {
            prefs.saveLoginStatus(true)
            prefs.saveEmail(email)
        }
    }

    fun logout() {

        viewModelScope.launch {

            prefs.saveLoginStatus(
                false
            )

        }
    }
}