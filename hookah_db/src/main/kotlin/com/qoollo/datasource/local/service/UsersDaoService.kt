package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IUsersDaoService
import com.qoollo.datasource.local.dao.UsersDao
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.User
import com.qoollo.domain.model.info.UserInfo
import java.util.*

class UsersDaoService(private val usersDao: UsersDao) : IUsersDaoService {

    override suspend fun insert(model: User): UUID = dbQuery { usersDao.insert(model.toEntity()) }

    override suspend fun insertAll(modelList: List<User>): List<UUID> = dbQuery {
        usersDao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun read(id: UUID): User? = dbQuery { usersDao.read(id)?.toDomain() }

    override suspend fun read(login: String, password: String): UserInfo? =
        dbQuery { usersDao.read(login, password)?.toDomain() }

    override suspend fun readAll(): List<User> = dbQuery {
        usersDao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: User) = dbQuery { usersDao.update(id, model.toEntity()) }

    override suspend fun updateAll(modelMap: Map<UUID, User>) = dbQuery {
        usersDao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { usersDao.delete(id) }

    override suspend fun deleteAll() = dbQuery { usersDao.deleteAll() }
}