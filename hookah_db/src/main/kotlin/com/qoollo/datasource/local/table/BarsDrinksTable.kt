package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.BarDrinkEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object BarsDrinksTable : AbstractTable<BarDrinkEntity>() {
    private const val BAR_ID = "bar_id"
    private const val DRINK_ID = "drink_id"
    private const val PRICE = "price"

    val barId = reference(BAR_ID, BarsTable.id, onDelete = ReferenceOption.CASCADE)
    val drinkId = reference(DRINK_ID, DrinksTable.id, onDelete = ReferenceOption.CASCADE)
    val price = double(PRICE)

    override fun ResultRow.toEntity(): BarDrinkEntity = BarDrinkEntity(
        barId = this[barId].value,
        drinkId = this[drinkId].value,
        price = this[price],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: BarDrinkEntity) {
        st[barId] = entity.barId
        st[drinkId] = entity.drinkId
        st[price] = entity.price
    }
}