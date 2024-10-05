package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.BarDrinkEntity
import com.qoollo.datasource.local.table.BarsDrinksTable
import com.qoollo.datasource.local.util.dbQuery
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.UUID

abstract class BarsDrinksDao() : BaseCRUDDao<BarDrinkEntity>(BarsDrinksTable) {
    fun delete(barId: UUID, drinkId: UUID) {
        BarsDrinksTable
            .deleteWhere {
                (BarsDrinksTable.barId eq barId) and
                        (BarsDrinksTable.drinkId eq drinkId)
            }
    }

    fun delete(barsId: List<UUID>, drinkId: UUID) {
        BarsDrinksTable
            .deleteWhere {
                (BarsDrinksTable.barId inList barsId) and
                        (BarsDrinksTable.drinkId eq drinkId)
            }
    }

    fun updatePrice(drinkId: UUID, price: Double) {
        BarsDrinksTable.update(
            { (BarsDrinksTable.drinkId eq drinkId) }
        ) { updateStatement ->
            updateStatement[BarsDrinksTable.price] = price
        }
    }
}