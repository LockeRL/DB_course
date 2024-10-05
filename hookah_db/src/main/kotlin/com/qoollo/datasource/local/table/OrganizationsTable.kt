package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.OrgEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object OrganizationsTable : AbstractTable<OrgEntity>() {
    private const val NAME = "name"
    private const val NAME_LENGTH = 50
    private const val DESCRIPTION = "description"
    private const val CATEGORY = "category"

    val name = varchar(NAME, length = NAME_LENGTH)
    val description = text(DESCRIPTION)
    val category = text(CATEGORY)

    override fun ResultRow.toEntity(): OrgEntity = OrgEntity(
        name = this[name],
        description = this[description],
        category = this[category],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: OrgEntity) {
        st[name] = entity.name
        st[description] = entity.description
        st[category] = entity.category
    }
}