package com.qoollo.domain.repository

import com.qoollo.domain.model.db.User
import com.qoollo.domain.model.info.UserInfo
import java.util.*

interface IUsersRepository {
    suspend fun insert(model: User): UUID
    suspend fun read(id: UUID): UserInfo?
    suspend fun read(login: String, password: String): UserInfo?
    suspend fun update(id: UUID, model: User)
    suspend fun delete(id: UUID)
}