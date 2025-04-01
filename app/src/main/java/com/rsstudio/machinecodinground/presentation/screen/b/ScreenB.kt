package com.rsstudio.machinecodinground.presentation.screen.b

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.window.Dialog
import com.rsstudio.machinecodinground.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(
) {

    val context = LocalContext.current
    val activity = context as? Activity

    LaunchedEffect(Unit) {
        activity?.window?.setBackgroundDrawableResource(android.R.color.transparent)
       // activity?.theme = R.style.Theme_Transparent
    }

    Box(
        modifier = Modifier.background(Color.Black.copy(alpha = 0.5f))
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Screen B")
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor = Color.Black.copy(
//                        alpha = 0.8f
//                    )
                    )
                )
            }
        ) {
            ScreenBContent(modifier = Modifier.padding(it))
        }
    }


}


@Composable
fun ScreenBContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
//            .background(color = Color.Black.copy(alpha = 0.2f)),
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Screen B"
        )
    }
}