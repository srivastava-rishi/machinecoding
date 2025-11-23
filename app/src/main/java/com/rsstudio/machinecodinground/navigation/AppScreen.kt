package com.rsstudio.machinecodinground.navigation

import com.rsstudio.machinecodinground.common.addArgs
import com.rsstudio.machinecodinground.navigation.AppNavArgs.AGE
import com.rsstudio.machinecodinground.navigation.AppNavArgs.NAME


object AppNavArgs {
    const val NAME = "name"
    const val AGE = "age"
}


sealed class AppScreen(val name: String, val route: String) {
    data object ScreenA : AppScreen("ScreenA", "ScreenA")
    data object ScreenB : AppScreen("ScreenB", "ScreenB".addArgs(NAME).addArgs(AGE))
}