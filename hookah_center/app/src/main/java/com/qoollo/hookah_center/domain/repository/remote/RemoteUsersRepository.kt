package com.qoollo.hookah_center.domain.repository.remote

import com.qoollo.hookah_center.common.repository.remote.IRemoteUsersRepository
import com.qoollo.hookah_center.datasource.remote.mapper.toDomain
import com.qoollo.hookah_center.datasource.remote.mapper.toDto
import com.qoollo.hookah_center.datasource.remote.service.IUserService
import com.qoollo.hookah_center.domain.model.User
import com.qoollo.hookah_center.domain.model.UserInfo
import java.util.UUID

class RemoteUsersRepository(private val service: IUserService) : IRemoteUsersRepository {
    override suspend fun signUp(user: User): Result<UUID> = service.signUp(user.toDto())
    override suspend fun login(login: String, password: String): Result<UserInfo> =
        service.getUserInfo(login, password).map { user -> user.toDomain() }
}