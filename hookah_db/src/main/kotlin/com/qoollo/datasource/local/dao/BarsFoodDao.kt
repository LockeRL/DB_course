package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.BarFoodEntity
import com.qoollo.datasource.local.table.BarsFoodTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.update
import java.util.*

abstract class BarsFoodDao() : BaseCRUDDao<BarFoodEntity>(BarsFoodTable) {
    fun delete(barId: UUID, foodId: UUID) {
        BarsFoodTable
            .deleteWhere {
                (BarsFoodTable.barId eq barId) and
                        (BarsFoodTable.foodId eq foodId)
            }
    }

    fun delete(barsId: List<UUID>, foodId: UUID) {
        BarsFoodTable
            .deleteWhere {
                (BarsFoodTable.barId inList barsId) and
                        (BarsFoodTable.foodId eq foodId)
            }
    }

    fun updatePrice(foodId: UUID, price: Double) {
        BarsFoodTable.update(
            { (BarsFoodTable.foodId eq foodId) }
        ) { updateStatement ->
            updateStatement[BarsFoodTable.price] = price
        }
    }
}