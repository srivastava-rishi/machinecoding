package com.rsstudio.machinecodinground.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import com.rsstudio.machinecodinground.glide.Heny


@Composable
fun ImageLoadingLibrary(
    modifier: Modifier,
    url: String,
    placeHolder: @Composable () -> Unit
) {

    var data by remember {
        mutableStateOf<ImageBitmap?>(null)
    }
    val hitIt = Heny.loadImage(
        url = url,
        onError = {
        },
        onSuccess = {
            data = it.asImageBitmap()
        }
    )
    data?.let {
        Image(bitmap = it, contentDescription = null)
    } ?: placeHolder
}


@Preview
@Composable
fun PreviewOfImageLoadingLibrary() {

}