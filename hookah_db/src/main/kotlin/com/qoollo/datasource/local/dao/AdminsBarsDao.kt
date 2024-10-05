package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.AdminBarEntity
import com.qoollo.datasource.local.table.AdminsBarsTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.select
import java.util.UUID

abstract class AdminsBarsDao() : BaseCRUDDao<AdminBarEntity>(AdminsBarsTable) {
    fun adminsInBar(barId: UUID): List<UUID> =
        AdminsBarsTable.select {
            AdminsBarsTable.barId eq barId
        }.map { res ->
            res[AdminsBarsTable.barId].value
        }

    fun delete(barId: UUID, adminId: UUID) {
        AdminsBarsTable.deleteWhere {
            (AdminsBarsTable.barId eq barId) and
                    (AdminsBarsTable.adminId eq adminId)
        }
    }
}