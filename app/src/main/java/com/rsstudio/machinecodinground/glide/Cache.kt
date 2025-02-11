package com.rsstudio.machinecodinground.glide

import android.graphics.Bitmap
import android.util.LruCache

object Cache {

    val cache = LruCache<String,Bitmap>(50)

    fun putImage(url: String, value: Bitmap) = cache.put(url,value)

    fun getImage(url: String) = cache.get(url)
}