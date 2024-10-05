package com.qoollo.hookah_center.datasource.remote.exception

import androidx.annotation.StringRes
import com.qoollo.hookah_center.R

sealed class NetworkErrors(@StringRes strId: Int = 0): RuntimeException() {
    data object Informational : NetworkErrors(R.string.informational_error)
    data object Redirection : NetworkErrors(R.string.redirection_error)
    data object ClientError : NetworkErrors(R.string.client_error)
    data object ServerError : NetworkErrors(R.string.server_error)
    data object ConvertError : NetworkErrors(R.string.server_error)
    data object UnknownError : NetworkErrors(R.string.unknown_error)
    data object InternetConnectionError: NetworkErrors(R.string.internet_connection_error)

}
