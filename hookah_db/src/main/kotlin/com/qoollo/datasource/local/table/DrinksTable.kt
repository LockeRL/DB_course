package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.DrinkEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object DrinksTable : AbstractTable<DrinkEntity>() {
    private const val NAME = "name"
    private const val NAME_LENGTH = 50
    private const val INGREDIENTS = "ingredients"
    private const val TYPE = "type"

    val name = varchar(NAME, length = NAME_LENGTH)
    val ingredients = text(INGREDIENTS)
    val type = text(TYPE)

    override fun ResultRow.toEntity(): DrinkEntity = DrinkEntity(
        name = this[name],
        ingredients = this[ingredients],
        type = this[type],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: DrinkEntity) {
        st[name] = entity.name
        st[ingredients] = entity.ingredients
        st[type] = entity.type
    }
}