package com.qoollo.hookah_center.presentation.ui.viewModel.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qoollo.hookah_center.common.repository.local.ILocalOwnerRepository
import com.qoollo.hookah_center.datasource.remote.exception.NetworkErrors
import com.qoollo.hookah_center.domain.model.User
import com.qoollo.hookah_center.common.repository.remote.IRemoteUsersRepository
import com.qoollo.hookah_center.domain.mapper.toOwner
import com.qoollo.hookah_center.presentation.mapper.toDomain
import com.qoollo.hookah_center.presentation.model.UserInfoViewData
import com.qoollo.hookah_center.presentation.ui.states.LoginUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class LoginViewModel(
    private val remoteUsersRep: IRemoteUsersRepository,
    private val localOwnerRep: ILocalOwnerRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState

    var login by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var firstName by mutableStateOf("")
        private set

    var secondName by mutableStateOf("")
        private set

    fun set() {
        _uiState.value = LoginUiState.Idle
    }

    fun updateLogin(newLogin: String) {
        login = newLogin
    }

    fun updatePassword(newPassword: String) {
        password = newPassword
    }

    fun updateFirstName(newFirstName: String) {
        firstName = newFirstName
    }

    fun updateSecondName(newSecondName: String) {
        secondName = newSecondName
    }

    fun login() {
        _uiState.value = LoginUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val u = UserInfoViewData(
                id = UUID.randomUUID(),
                login = "l",
                firstName = "f",
                secondName = "s"
            )
            val new = u.toDomain().toOwner()
            println(new)
            localOwnerRep.insert(u.toDomain().toOwner())
            _uiState.value = LoginUiState.Success(u.id)
//            remoteUsersRep.login(login, password)
//                .onSuccess {user ->
//                    localOwnerRep.insert(user.toOwner())
//                    _uiState.value = LoginUiState.Success(user.id)
//                }
//                .onFailure {error ->
//                    _uiState.value = LoginUiState.Error(error as NetworkErrors)
//                }
        }
    }

    fun signUp() {
        _uiState.value = LoginUiState.Loading
        val user = User(
            login = login,
            password = password,
            firstName = firstName,
            secondName = secondName
        )
        viewModelScope.launch(Dispatchers.IO) {
            remoteUsersRep.signUp(user = user)
                .onSuccess { id ->
                    localOwnerRep.insert(user.toOwner(id))
                    _uiState.value = LoginUiState.Success(id)
                }
                .onFailure { error ->
                    _uiState.value = LoginUiState.Error(error as NetworkErrors)
                }
        }
    }
}