package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.UserEntity
import com.qoollo.datasource.local.entity.info.UserInfoEntity
import com.qoollo.datasource.local.mapper.toUserInfoEntity
import com.qoollo.datasource.local.table.UsersTable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

abstract class UsersDao() : BaseCRUDDao<UserEntity> (UsersTable) {
    fun read(login: String, password: String): UserInfoEntity? =
        UsersTable.select {
            (UsersTable.login eq login) and
                    (UsersTable.password eq password)
        }.map { res ->
            res.toUserInfoEntity()
        }.singleOrNull()
}