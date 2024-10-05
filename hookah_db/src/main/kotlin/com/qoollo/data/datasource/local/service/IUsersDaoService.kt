package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.User
import com.qoollo.domain.model.info.UserInfo
import java.util.*

interface IUsersDaoService {
    suspend fun insert(model: User): UUID
    suspend fun insertAll(modelList: List<User>): List<UUID>
    suspend fun read(id: UUID): User?
    suspend fun read(login: String, password: String): UserInfo?
    suspend fun readAll(): List<User>
    suspend fun update(id: UUID, model: User)
    suspend fun updateAll(modelMap: Map<UUID, User>)
    suspend fun delete(id: UUID)
    suspend fun deleteAll()
}