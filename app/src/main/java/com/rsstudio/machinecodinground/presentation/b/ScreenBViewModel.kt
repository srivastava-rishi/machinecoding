package com.rsstudio.machinecodinground.presentation.b

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rsstudio.machinecodinground.navigation.AppNavArgs

class ScreenBViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var name = savedStateHandle[AppNavArgs.NAME] ?: ""
    var age = savedStateHandle[AppNavArgs.AGE] ?: ""

    var uiState by mutableStateOf(ScreenBUiState())
        private set

    init {
        uiState = uiState.copy(
            name = name,
            age = age
        )
    }

}

data class ScreenBUiState(
    val name: String = "",
    val age: String = "",
)