package com.rsstudio.machinecodinground.navigation.actions

/**
 * Add all you app screen actions here ====================================
 */


sealed class AScreenActions {
    data object OpenBScreen : AScreenActions()
}

sealed class BScreenActions {
    data object OnBack :  BScreenActions()
}

