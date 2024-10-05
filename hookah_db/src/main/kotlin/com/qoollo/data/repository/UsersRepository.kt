package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.IComplexDaoService
import com.qoollo.data.datasource.local.service.IUsersDaoService
import com.qoollo.domain.model.db.User
import com.qoollo.domain.model.info.UserInfo
import com.qoollo.domain.repository.IUsersRepository
import java.util.*

class UsersRepository(
    private val userService: IUsersDaoService,
    private val complexService: IComplexDaoService
) : IUsersRepository {
    override suspend fun insert(model: User): UUID = userService.insert(model)

    override suspend fun read(id: UUID): UserInfo? = complexService.getUserInfo(id)

    override suspend fun read(login: String, password: String): UserInfo? = userService.read(login, password)

    override suspend fun update(id: UUID, model: User) = userService.update(id, model)

    override suspend fun delete(id: UUID) = userService.delete(id)
}