package com.example.praktam_2417051051.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "thryve_preferences"
)

class UserPreferences(
    private val context: Context
) {

    companion object {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_EMAIL = stringPreferencesKey("user_email")
    }

    val loginStatus = context.dataStore.data.map {
        it[IS_LOGGED_IN] ?: false
    }

    val userName = context.dataStore.data.map {
        it[USER_NAME] ?: "Kumi"
    }

    val userEmail = context.dataStore.data.map {
        it[USER_EMAIL] ?: "kumi@gmail.com"
    }

    suspend fun saveLoginStatus(status: Boolean) {
        context.dataStore.edit {
            it[IS_LOGGED_IN] = status
        }
    }

    suspend fun saveProfile(name: String, email: String) {
        context.dataStore.edit {
            it[USER_NAME] = name
            it[USER_EMAIL] = email
        }
    }

    suspend fun saveEmail(email: String) {
        context.dataStore.edit {
            it[USER_EMAIL] = email
        }
    }
}