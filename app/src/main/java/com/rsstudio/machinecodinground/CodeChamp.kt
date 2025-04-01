//package com.rsstudio.machinecodinground
//
//import java.io.IOException
//import java.lang.System.currentTimeMillis
//import java.lang.Thread.sleep
//
//fun main() {
//    val loader = ImageLoader()
//    val request = Request(imageUrl = "https://1.image.link", ImageView())
//    loader.load(request)
//    println("Sending load request: $request")
//}
//
//class ImageLoader {
//    fun load(request: Request) {
//        println("Got load request: $request")
//        val downloadImage = downloadBitmap(request)
//        val decode = decodeBitmap(downloadImage)
//    }
//
//    fun downloadBitmap(request: Request): BitmapStream {
//        println("Download started at ${currentTimeMillis()} for $request...")
//        sleep((500..2000).random().toLong())
//        if ((1..10).random() < 3) {
//            throw IOException("Download failed for $request")
//        }
//        println("Download successful for $request")
//        return BitmapStream(request, byteArrayOf())
//    }
//
//    fun decodeBitmap(bitmapStream: BitmapStream): Bitmap {
//        println("Decode started for $bitmapStream...")
//        sleep((100..200).random().toLong())
//        println("Decode finished for $bitmapStream")
//        return Bitmap(bitmapStream)
//    }
//
//    fun cancelRequest(request: Request) {
//        TODO()
//    }
//}
//
//data class Request(val imageUrl: String, val imageView: ImageView)
//
//data class BitmapStream(private val request: Request, private val bytes: ByteArray)
//
//data class Bitmap(private val stream: BitmapStream)
//
//class ImageView {
//    private var bitmap: Bitmap? = null
//
//    fun setImageBitmap(bitmap: Bitmap) {
//        this.bitmap = bitmap
//        println("Bitmap $bitmap set at ${currentTimeMillis()} for ImageView $this")
//    }
//}