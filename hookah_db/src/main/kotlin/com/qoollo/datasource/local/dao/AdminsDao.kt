package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.AdminEntity
import com.qoollo.datasource.local.table.AdminsTable
import org.jetbrains.exposed.sql.select
import java.util.UUID

abstract class AdminsDao() : BaseCRUDDao<AdminEntity>(AdminsTable) {
    fun readByUserId(userId: UUID): AdminEntity? =
        AdminsTable.select {
            AdminsTable.userId eq userId
        }.map { res ->
            with(AdminsTable) {
                res.toEntity()
            }
        }.singleOrNull()
}