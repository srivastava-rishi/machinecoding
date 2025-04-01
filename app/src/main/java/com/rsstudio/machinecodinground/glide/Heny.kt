package com.rsstudio.machinecodinground.glide

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

object Heny {
    private val requestMap = ConcurrentHashMap<String, Call>()

    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    fun loadImage(
        url: String,
        coroutineScope: CoroutineScope,
        onSuccess: (Bitmap) -> Unit,
        onError: (Exception) -> Unit
    ) {
        requestMap[url]?.cancel()

        val request = Request.Builder().url(url).build()
        val call = client.newCall(request)
        requestMap[url] = call // Track active request

        coroutineScope.launch(Dispatchers.IO) {
            try {
                val response = call.execute()
                val inputStream = response.body?.byteStream() ?: throw IOException("Null InputStream")
                val bitmap = BitmapFactory.decodeStream(inputStream)
                Cache.putImage(url, bitmap)
                withContext(Dispatchers.Main) { onSuccess(bitmap) }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) { onError(e) }
            } finally {
                requestMap.remove(url) // Remove completed/cancelled requests
            }
        }
    }

    fun cancelRequest(url: String) {
        requestMap[url]?.cancel()
        requestMap.remove(url)
    }
}
