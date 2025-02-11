package com.rsstudio.machinecodinground.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rsstudio.machinecodinground.presentation.screen.a.ScreenA
import com.rsstudio.machinecodinground.presentation.screen.b.ScreenB
import com.rsstudio.machinecodinground.presentation.screen.reminderlist.ReminderListScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppScreen.ScreenA.route,
    navActions: AppNavigationActions,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppScreen.ScreenA.route) {
            ScreenA(
                opeScreenB = {
                    navController.navigate(AppScreen.ScreenB.route)
                }
            )
        }

        composable(route = AppScreen.ScreenB.route) {
            ScreenB()
        }


        composable(AppScreen.ReminderListScreen.route) {
            ReminderListScreen()
        }
    }
}