package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.HookahEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object HookahsTable : AbstractTable<HookahEntity>() {
    private const val NAME = "name"
    private const val NAME_LENGTH = 50
    private const val DESCRIPTION = "description"
    private const val TYPE = "type"

    val name = varchar(NAME, length = NAME_LENGTH)
    val description = text(DESCRIPTION)
    val type = text(TYPE)

    override fun ResultRow.toEntity(): HookahEntity = HookahEntity(
        name = this[name],
        description = this[description],
        type = this[type],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: HookahEntity) {
        st[name] = entity.name
        st[description] = entity.description
        st[type] = entity.type
    }
}