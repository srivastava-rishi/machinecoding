package com.rsstudio.machinecodinground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rsstudio.machinecodinground.navigation.AppNavGraph
import com.rsstudio.machinecodinground.navigation.AppNavigationActions
import com.rsstudio.machinecodinground.presentation.theme.MachineCodingRoundTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MachineCodingRoundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReminderApp(
                        onFinish = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ReminderApp(
    onFinish: () -> Unit
) {
    val navController = rememberNavController()
    val navActions = remember(navController) {
        AppNavigationActions(navController, onFinish)
    }
    AppNavGraph(
        navController = navController,
        navActions = navActions
    )
}
