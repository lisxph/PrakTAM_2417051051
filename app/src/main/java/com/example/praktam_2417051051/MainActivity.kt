package com.example.praktam_2417051051

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.praktam_2417051051.Homepage.HomePage
import com.example.praktam_2417051051.ui.theme.PrakTAM_2417051051Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2417051051Theme {
                HomePage()
            }
        }
    }
}
