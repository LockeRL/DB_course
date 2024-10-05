package com.qoollo.hookah_center.common.repository.remote

import com.qoollo.hookah_center.domain.model.User
import com.qoollo.hookah_center.domain.model.UserInfo
import java.util.UUID

interface IRemoteUsersRepository {
    suspend fun signUp(user: User): Result<UUID>
    suspend fun login(login: String, password: String): Result<UserInfo>
}