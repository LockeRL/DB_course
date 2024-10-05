package com.qoollo.hookah_center.datasource.remote.service

import com.qoollo.hookah_center.datasource.remote.model.UserDto
import com.qoollo.hookah_center.datasource.remote.model.UserInfoDto
import java.util.UUID

interface IUserService {
    suspend fun getUserInfo(userId: UUID): Result<UserInfoDto>

    suspend fun getUserInfo(login: String, password: String): Result<UserInfoDto>

    suspend fun signUp(user: UserDto): Result<UUID>
}