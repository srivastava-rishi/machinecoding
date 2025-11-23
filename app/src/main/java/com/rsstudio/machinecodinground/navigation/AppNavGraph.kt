package com.rsstudio.machinecodinground.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rsstudio.machinecodinground.presentation.a.ScreenA
import com.rsstudio.machinecodinground.presentation.b.ScreenB


@Composable
fun AppNavGraph(
    startDestination: String,
    navController: NavHostController,
    onAction: AppNavAction
) {
    NavHost(
        startDestination = startDestination,
        navController = navController,
    ) {
        composable(AppScreen.ScreenA.route) {
            ScreenA(
                onAction = onAction::navigateFromScreenA
            )
        }

        composable(AppScreen.ScreenB.route) { backStackEntry ->
            ScreenB()
        }
    }
}