package com.example.praktam_2417051051

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.praktam_2417051051.Homepage.Dashboard
import com.example.praktam_2417051051.Homepage.JournalPage
import com.example.praktam_2417051051.ui.theme.PrakTAM_2417051051Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrakTAM_2417051051Theme {
                var currentScreen by remember { mutableIntStateOf(0) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    when (currentScreen) {
                        0 -> Dashboard(
                            onNavigateToJournal = { currentScreen = 1 },
                            onNavigateToHome = { currentScreen = 0 }
                        )
                        1 -> JournalPage(
                            onNavigateToHome = { currentScreen = 0 }
                        )
                    }
                }
            }
        }
    }
}
