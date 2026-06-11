package com.example.praktam_2417051051.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.praktam_2417051051.ui.components.BottomBar
import com.example.praktam_2417051051.ui.components.SettingItem
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktam_2417051051.viewmodel.LoginViewModel
import com.example.praktam_2417051051.navigation.Screen

@Composable
fun SettingsScreen(
    navController: NavController
) {
    val loginVm: LoginViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            item {

                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                SettingItem(
                    icon = Icons.Outlined.Person,
                    title = "Edit Profile",
                    onClick = {

                        navController.navigate(
                            Screen.EditProfile.route
                        )

                    }
                )

                SettingItem(
                    icon = Icons.Outlined.ExitToApp,
                    title = "Logout",
                    onClick = {

                        loginVm.logout()

                        navController.navigate(
                            Screen.Login.route
                        ) {

                            popUpTo(0)

                        }
                    }
                )
            }
        }
    }
}