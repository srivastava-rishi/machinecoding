package com.rsstudio.machinecodinground.navigation


sealed class ScreenAActions {
    data object OnBack : ScreenAActions()
    data class OpenScreenB(val name: String, val age: String) : ScreenAActions()
}


sealed class ScreenBActions {
    data object OnBack : ScreenBActions()
}