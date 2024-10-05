package com.qoollo.hookah_center.datasource.remote.service

import com.qoollo.hookah_center.datasource.remote.api.UsersApi
import com.qoollo.hookah_center.datasource.remote.mapper.toResult
import com.qoollo.hookah_center.datasource.remote.model.UserDto
import com.qoollo.hookah_center.datasource.remote.model.UserInfoDto
import com.qoollo.hookah_center.datasource.remote.util.runNetworkRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class UserService(
    private val retrofit: UsersApi,
    private val dispatchers: CoroutineDispatcher = Dispatchers.IO
) : IUserService {
    override suspend fun getUserInfo(userId: UUID): Result<UserInfoDto> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.getUserInfo(userId).toResult()
            }
        }


    override suspend fun getUserInfo(login: String, password: String): Result<UserInfoDto> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.getUserInfo(login, password).toResult()
            }
        }

    override suspend fun signUp(user: UserDto): Result<UUID> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.signUp(user).toResult()
            }
        }

}