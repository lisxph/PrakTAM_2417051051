package com.example.praktam_2417051051

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.praktam_2417051051.navigation.AppNavigation
import com.example.praktam_2417051051.ui.theme.ThryveTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ThryveTheme {

                val navController =
                    rememberNavController()

                AppNavigation(navController)

            }
        }
    }
}
