package com.qoollo.hookah_center.presentation.ui.states

import com.qoollo.hookah_center.datasource.remote.exception.NetworkErrors
import com.qoollo.hookah_center.presentation.model.UserInfoViewData
import java.util.UUID

sealed class LoginUiState {
    data object Idle: LoginUiState()
    data object Loading : LoginUiState()
    data class Success(val uuid: UUID): LoginUiState()
    data class Error(val error: NetworkErrors): LoginUiState()
}