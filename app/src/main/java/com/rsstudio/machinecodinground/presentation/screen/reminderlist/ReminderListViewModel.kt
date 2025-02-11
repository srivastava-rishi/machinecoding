package com.rsstudio.machinecodinground.presentation.screen.reminderlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.rsstudio.machinecodinground.data.restclient.AppApiClientService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Response
import javax.inject.Inject

@HiltViewModel
class ReminderListViewModel @Inject constructor(
    private val appApiClientService: AppApiClientService
) : ViewModel() {

    var uiState by mutableStateOf(ReminderListUiState())
        private set

    init {
        fetchAllReminders()
    }

    private fun fetchAllReminders() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response: Response = appApiClientService.makeGetRequest("https://jsonplaceholder.typicode.com/todos")

                response.use {
                    if (it.isSuccessful) {
                        val jsonBody = it.body?.string()
                        jsonBody?.let { json ->
                            val listType = object : TypeToken<List<ReminderResponse>>() {}.type
                            val parsedReminders: List<ReminderResponse> = Gson().fromJson(json, listType)
                            println("Fetched ${parsedReminders.size} reminders successfully! $parsedReminders")
                        }
                    } else {
                        println("Error fetching reminders: ${it.code}")
                    }
                }
            } catch (e: Exception) {
                println("Exception occurred: ${e.message}")
            }
        }
    }

    fun onEvent(event: ReminderListUIEvent) {
        when (event) {

            else -> {}
        }
    }
}


data class ReminderListUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val list: List<Reminder> = emptyList()
) {
    fun isLoading() = screenState == ScreenState.LOADING
}

sealed interface ReminderListUIEvent {
}

data class Reminder(
    val id: String,
    val title: String,
    val description: String,
    val interval: String,
    val fromApi: Boolean
)

enum class ScreenState {
    NONE,
    LOADING,
    ERROR
}

data class ReminderResponse(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("completed") val completed: Boolean
)