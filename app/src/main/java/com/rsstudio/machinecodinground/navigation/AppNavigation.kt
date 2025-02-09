package com.rsstudio.machinecodinground.navigation


/**
 * Args irrespective of screens are kept here
 */

object AppArgs {
    const val ARG_REMINDER_ID = "news_Id"
}

sealed class AppScreen(val name: String, val route: String) {
    data object ScreenA : AppScreen("a", "a")
    data object ScreenB : AppScreen("b", "b")
}