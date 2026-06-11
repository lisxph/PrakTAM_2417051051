package com.example.praktam_2417051051.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.praktam_2417051051.R
import com.example.praktam_2417051051.navigation.Screen
import kotlinx.coroutines.delay
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.example.praktam_2417051051.data.datastore.UserPreferences

@Composable
fun SplashScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val prefs = UserPreferences(context)
    val isLoggedIn = prefs.loginStatus.collectAsState(initial = false)

    LaunchedEffect(isLoggedIn.value) {
        delay(2500)
        if (isLoggedIn.value) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Splash.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Splash.route) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo_thryve),
            contentDescription = null
        )
    }
}