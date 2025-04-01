package com.rsstudio.machinecodinground.animation

import android.app.LocaleConfig
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Ball() {
    val firstChipYOffset = remember { Animatable(0f) }
    var clicked by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(clicked) {
        if (clicked) {
            firstChipYOffset.animateTo(
                targetValue = 200f,
                animationSpec = tween(1000)
            )
        } else {
            firstChipYOffset.animateTo(
                targetValue = 0f,
                animationSpec = tween(1000)
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

     //   val height = LocalConfiguration.current.screenHeightDp.dp
        val height = with(LocalDensity.current) { LocalConfiguration.current.screenHeightDp.dp.toPx() }

        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.Red, shape = CircleShape)
                .clickable {
                    clicked = !clicked
                }
                .graphicsLayer {
                    translationY = firstChipYOffset.value
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BallPreview() {
    Ball()
}