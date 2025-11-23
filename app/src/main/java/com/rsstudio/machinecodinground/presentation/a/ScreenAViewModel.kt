package com.rsstudio.machinecodinground.presentation.a

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ScreenAViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(ScreenAUiState())
        private set

    var uiSideEffect by mutableStateOf<ScreenASideEffects>(ScreenASideEffects.None)
        private set


    fun onEvent(event: ScreenAEvents) {
        when (event) {
            is ScreenAEvents.OnDone -> {
                uiSideEffect = ScreenASideEffects.NavigateToScreenB(event.name, event.age)
            }
        }
    }

    fun resetSideEffect() {
        uiSideEffect = ScreenASideEffects.None
    }
}

data class ScreenAUiState(
    val name: String = "",
    val age: String = ""
)

sealed class ScreenAEvents {
    data class OnDone(val name: String, val age: String) : ScreenAEvents()
}

sealed class ScreenASideEffects {
    data object None : ScreenASideEffects()
    data class NavigateToScreenB(val name: String, val age: String) : ScreenASideEffects()
}