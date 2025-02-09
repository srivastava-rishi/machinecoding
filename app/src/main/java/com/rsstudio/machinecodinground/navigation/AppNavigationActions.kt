package com.rsstudio.machinecodinground.navigation

import androidx.navigation.NavController
import com.rsstudio.machinecodinground.navigation.actions.AScreenActions
import com.rsstudio.machinecodinground.navigation.actions.BScreenActions

class AppNavigationActions(
    private val navController: NavController,
    private val onFinish: () -> Unit
) {

    private fun back() {
        navController.popBackStack()
    }

    private fun finishActivity() {
        onFinish()
    }

    fun navigateFromScreenA(actions: AScreenActions) {
        when (actions) {
            is AScreenActions.OpenBScreen -> {

            }
        }
    }

    fun navigateFromScreenB(actions: BScreenActions) {
        when (actions) {
            BScreenActions.OnBack -> {

            }
        }
    }
}