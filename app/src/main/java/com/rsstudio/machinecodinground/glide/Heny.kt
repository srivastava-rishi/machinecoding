package com.rsstudio.machinecodinground.glide

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

object Heny {
    fun loadImage(url: String, onSuccess: (Bitmap) -> Unit, onError: (Exception) -> Unit) {
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        scope.launch {
            try {
                val cachedBitmap = Cache.getImage(url)
                if (cachedBitmap != null) {
                    withContext(Dispatchers.Main) { onSuccess(cachedBitmap) }
                } else {
                    val bitmap = downloadBitmap(url)
                    Cache.putImage(url, bitmap)
                    withContext(Dispatchers.Main) {
                        onSuccess(bitmap)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) { onError(e) }
            }
        }
    }

    private fun downloadBitmap(url: String): Bitmap {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.doInput = true
        connection.connect()
        val inputStream = connection.inputStream
        return BitmapFactory.decodeStream(inputStream)
    }
}