package com.example.praktam_2417051051.navigation

sealed class Screen(val route:String){

    object Splash : Screen("splash")

    object Login : Screen("login")

    object Register : Screen("register")

    object Home : Screen("home")

    object Todo : Screen("todo")

    object Mood : Screen("mood")

    object Journal : Screen("journal")

    object JournalDetail :
        Screen("journal_detail")

    object Badge : Screen("badge")

    object Settings : Screen("settings")
    object EditProfile :
        Screen("edit_profile")

    object TaskForm : Screen("task_form")
    object JournalForm : Screen("journal_form")
}