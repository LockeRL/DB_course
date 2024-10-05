package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.BarHookahEntity
import com.qoollo.datasource.local.table.BarsHookahsTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.update
import java.util.*

abstract class BarsHookahsDao() : BaseCRUDDao<BarHookahEntity>(BarsHookahsTable) {
    fun delete(barId: UUID, hookahId: UUID) {
        BarsHookahsTable
            .deleteWhere {
                (BarsHookahsTable.barId eq barId) and
                        (BarsHookahsTable.hookahId eq hookahId)
            }
    }

    fun delete(barsId: List<UUID>, hookahId: UUID) {
        BarsHookahsTable
            .deleteWhere {
                (BarsHookahsTable.barId inList barsId) and
                        (BarsHookahsTable.hookahId eq hookahId)
            }
    }

    fun updatePrice(hookahId: UUID, price: Double) {
        BarsHookahsTable.update(
            { (BarsHookahsTable.hookahId eq hookahId) }
        ) { updateStatement ->
            updateStatement[BarsHookahsTable.price] = price
        }
    }
}