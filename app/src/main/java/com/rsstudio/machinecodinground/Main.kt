package com.rsstudio.machinecodinground

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.lang.System.currentTimeMillis

/**
 * Architect a simple library that handles asynchronous requests using RxJava/Coroutines
 *
 * Assume that the asynchronous operation is loading an image into an ImageView from a URL.
 * Use stubs (provided in project) for networking and ImageView APIs to keep it simple
 * and instead focus on managing the async operations.
 *
 * Functional requirements:
 * 1. When user sends a load request, fire the request for the image url, get the bitmap,
 * apply the bitmap to the ImageView
 * 2. Add support for sending multiple image requests at the same time, in parallel
 * 3. Provide API for cancelling in-flight requests
 *
 **/

fun main() {
    runBlocking {
        val hm = mutableMapOf<String, Job>()
        runCatching {
            val join = CoroutineScope(Dispatchers.IO).launch {
                val loader = ImageLoader()
                val request1 = Request(imageUrl = "https://1.image.link", ImageView())
                val request2 = Request(imageUrl = "https://google.com", ImageView())
                val a = launch { loader.load(request1) }
                hm[request1.imageUrl] = a
                val b = launch { loader.load(request2) }
                hm[request2.imageUrl] = b
                delay(20)
                // cancel it
                hm[request1.imageUrl]?.cancel()
                println("Sending load request: $request1")
            }
            join.join()
        }
    }
}

class ImageLoader {
    suspend fun load(request: Request) {
        println("Got load request: $request")
        val downloadImage = downloadBitmap(request)
        request.imageView.setImageBitmap(decodeBitmap(downloadImage))
        println("line no 41: ${request.imageView}")
    }

    private suspend fun downloadBitmap(request: Request): BitmapStream {
        println("Download started at ${currentTimeMillis()} for $request...")
        delay((500..2000).random().toLong())
        if ((1..10).random() < 3) {
            throw IOException("Download failed for $request")
        }
        println("Download successful for $request")
        return BitmapStream(request, byteArrayOf())
    }

    private suspend fun decodeBitmap(bitmapStream: BitmapStream): Bitmap {
        println("Decode started for $bitmapStream...")
        delay((100..200).random().toLong())
        println("Decode finished for $bitmapStream")
        return Bitmap(bitmapStream)
    }

    fun cancelRequest(request: Request) {
        TODO()
    }
}

data class Request(val imageUrl: String, val imageView: ImageView)

data class BitmapStream(private val request: Request, private val bytes: ByteArray)

data class Bitmap(private val stream: BitmapStream)

class ImageView {
    private var bitmap: Bitmap? = null

    fun setImageBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
        println("Bitmap $bitmap set at ${currentTimeMillis()} for ImageView $this")
    }
}

