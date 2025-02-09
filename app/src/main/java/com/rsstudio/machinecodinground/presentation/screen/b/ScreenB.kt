package com.rsstudio.machinecodinground.presentation.screen.b

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
      //      .background(color = Color.Black.copy(alpha = 0.2f))
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Screen B")
                    },
                  //  colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Black.copy(alpha = 0.2f))
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
//    val localConfiguration = LocalConfiguration.current
//    val screenHeight = localConfiguration.screenHeightDp.dp
//    val screenWidth = localConfiguration.screenWidthDp.dp
//    Box {
//        Box(
//            modifier = modifier
//                .fillMaxSize()
//                .offset(x = screenWidth / 2 - 30.dp, y = screenHeight * 0.36f)
//                .background(black50)
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(60.dp)
//                    .background(color = Color.Blue, shape = CircleShape)
//            )
//        }
//
//    }

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