package com.rsstudio.machinecodinground.data.restclient

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import javax.inject.Inject


class AppApiClientService @Inject constructor(
    private val okHttpClient: OkHttpClient
) {

    fun makeGetRequest(url: String): Response {
        val request = Request.Builder()
            .url(url)
            .get()
            .build()
        return executeRequest(request)
    }

    fun makePostRequest(url: String, jsonBody: String): Response {
        val requestBody = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        return executeRequest(request)
    }


    // Generic DELETE request
    fun makeDeleteRequest(url: String): Response {
        val request = Request.Builder()
            .url(url)
            .delete()
            .build()

        return executeRequest(request)
    }

    private fun executeRequest(request: Request) = okHttpClient.newCall(request).execute()
}