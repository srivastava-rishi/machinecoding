package com.rsstudio.machinecodinground.navigation

import androidx.navigation.NavHostController
import com.rsstudio.machinecodinground.common.withArgs

class AppNavAction(
    private val navController: NavHostController,
    val finish: () -> Unit
) {
    private fun onBack() {
        navController.popBackStack()
    }

    fun onFinish() {
        finish()
    }

    fun navigateFromScreenA(actions: ScreenAActions) {
        when (actions) {
            ScreenAActions.OnBack -> {
                onBack()
            }

            is ScreenAActions.OpenScreenB -> {
                navController.navigate(
                    AppScreen.ScreenB.name.withArgs(
                        AppNavArgs.NAME, actions.name
                    ).withArgs(
                        AppNavArgs.AGE, actions.age
                    )
                )
            }
        }
    }

    fun navigateFromScreenB(actions: ScreenBActions) {
        when (actions) {
            ScreenBActions.OnBack -> {
                onBack()
            }
        }
    }
}