package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.FoodEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object FoodTable : AbstractTable<FoodEntity>() {
    private const val NAME = "name"
    private const val NAME_LENGTH = 50
    private const val INGREDIENTS = "ingredients"

    val name = varchar(NAME, length = NAME_LENGTH)
    val ingredients = text(INGREDIENTS)

    override fun ResultRow.toEntity(): FoodEntity = FoodEntity(
        name = this[name],
        ingredients = this[ingredients],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: FoodEntity) {
        st[name] = entity.name
        st[ingredients] = entity.ingredients
    }
}