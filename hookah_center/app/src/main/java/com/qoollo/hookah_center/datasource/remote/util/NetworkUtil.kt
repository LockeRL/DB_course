package com.qoollo.hookah_center.datasource.remote.util

import com.qoollo.hookah_center.datasource.remote.exception.NetworkErrors
import java.io.IOException

suspend fun <T> runNetworkRequest(requestAction: suspend () -> Result<T>): Result<T> =
    try {
        requestAction()
    } catch (e: IOException) {
        println(e.message)
        Result.failure(NetworkErrors.InternetConnectionError)
    } catch (e: Exception) {
        println(e.message)
        Result.failure(NetworkErrors.UnknownError)
    }

