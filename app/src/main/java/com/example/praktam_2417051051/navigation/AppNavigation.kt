package com.example.praktam_2417051051.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.praktam_2417051051.ui.screens.*
import com.example.praktam_2417051051.viewmodel.*

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    val quoteVm: QuoteViewModel = viewModel()
    val todoVm: TodoViewModel = viewModel()
    val moodVm: MoodViewModel = viewModel()
    val journalVm: JournalViewModel = viewModel()
    val badgeVm: BadgeViewModel = viewModel()
    val profileVm: ProfileViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController, quoteVm, todoVm, moodVm, journalVm, profileVm)
        }

        composable(Screen.Todo.route) {
            TodoScreen(navController, todoVm)
        }

        composable(Screen.Mood.route) {
            MoodScreen(navController, moodVm)
        }

        composable(Screen.Journal.route) {
            JournalScreen(navController, journalVm)
        }

        composable(
            "${Screen.JournalDetail.route}/{journalId}"
        ) { backStackEntry ->
            val journalId = backStackEntry.arguments?.getString("journalId")?.toIntOrNull() ?: 0
            JournalDetailScreen(
                journalId = journalId,
                navController = navController,
                journalVm = journalVm
            )
        }

        composable(Screen.Badge.route) {
            BadgeScreen(navController, badgeVm, todoVm, moodVm, journalVm)
        }

        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }

        composable(
            Screen.EditProfile.route
        ) {
            EditProfileScreen(
                navController,
                profileVm
            )
        }

        composable(
            "${Screen.TaskForm.route}?taskId={taskId}"
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            TaskFormScreen(
                taskId = taskId,
                navController = navController,
                todoVm = todoVm
            )
        }

        composable(
            "${Screen.JournalForm.route}?journalId={journalId}"
        ) { backStackEntry ->
            val journalId = backStackEntry.arguments?.getString("journalId")?.toIntOrNull()
            JournalFormScreen(
                journalId = journalId,
                navController = navController,
                journalVm = journalVm
            )
        }
    }
}