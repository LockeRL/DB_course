package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.BarFoodEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object BarsFoodTable : AbstractTable<BarFoodEntity>() {
    private const val BAR_ID = "bar_id"
    private const val FOOD_ID = "food_id"
    private const val PRICE = "price"

    val barId = reference(BAR_ID, BarsTable.id, onDelete = ReferenceOption.CASCADE)
    val foodId = reference(FOOD_ID, FoodTable.id, onDelete = ReferenceOption.CASCADE)
    val price = double(PRICE)

    override fun ResultRow.toEntity(): BarFoodEntity = BarFoodEntity(
        barId = this[barId].value,
        foodId = this[foodId].value,
        price = this[price],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: BarFoodEntity) {
        st[barId] = entity.barId
        st[foodId] = entity.foodId
        st[price] = entity.price
    }

}