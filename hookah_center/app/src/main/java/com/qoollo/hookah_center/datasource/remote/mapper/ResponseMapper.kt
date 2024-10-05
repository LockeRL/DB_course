package com.qoollo.hookah_center.datasource.remote.mapper

import com.qoollo.hookah_center.datasource.remote.exception.NetworkErrors
import retrofit2.Response


private val INFORMATIONAL_RANGE = 100 .. 199
private val OK_RANGE = 200 .. 299
private val REDIRECTION_RANGE = 300 .. 399
private val CLIENT_ERROR_RANGE = 400 .. 499
private val SERVER_ERROR_RANGE = 500 .. 599

fun <T> Response<T>.toResult(): Result<T> =
    when (this.code()) {
        in OK_RANGE -> {
            val content = body()
            if (content != null) Result.success(content) else Result.failure(NetworkErrors.ConvertError)
        }
        in CLIENT_ERROR_RANGE -> Result.failure(NetworkErrors.ClientError)
        in SERVER_ERROR_RANGE -> Result.failure(NetworkErrors.ServerError)
        in REDIRECTION_RANGE -> Result.failure(NetworkErrors.Redirection)
        in INFORMATIONAL_RANGE -> Result.failure(NetworkErrors.Informational)
        else -> Result.failure(NetworkErrors.UnknownError)
    }.also { println(this.code()) }
