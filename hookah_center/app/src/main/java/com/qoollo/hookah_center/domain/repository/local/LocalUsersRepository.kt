package com.qoollo.hookah_center.domain.repository.local

import com.qoollo.hookah_center.common.repository.local.ILocalUsersRepository
import com.qoollo.hookah_center.datasource.local.db.dao.UserDao
import com.qoollo.hookah_center.datasource.local.db.mapper.toDomain
import com.qoollo.hookah_center.datasource.local.db.mapper.toEntity
import com.qoollo.hookah_center.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class LocalUsersRepository(private val dao: UserDao) : ILocalUsersRepository {
    override suspend fun insertUser(user: UserInfo) = dao.insertUser(user.toEntity())

    override fun getUser(id: UUID): Flow<UserInfo> =
        dao.getUser(id).map { user -> user.toDomain() }
}