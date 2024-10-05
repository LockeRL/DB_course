package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.AdminBarEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object AdminsBarsTable : AbstractTable<AdminBarEntity>() {
    private const val BAR_ID = "bar_id"
    private const val ADMIN_ID = "admin_id"
    private const val APPOINTED = "appointed"
    private const val APPOINTED_LENGTH = 20

    val barId = reference(BAR_ID, BarsTable.id, onDelete = ReferenceOption.CASCADE)
    val adminId = reference(ADMIN_ID, AdminsTable.id, onDelete = ReferenceOption.CASCADE)
    val appointed = varchar(APPOINTED, length = APPOINTED_LENGTH)

    override fun ResultRow.toEntity(): AdminBarEntity = AdminBarEntity(
        barId = this[barId].value,
        adminId = this[adminId].value,
        appointed = this[appointed],
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: AdminBarEntity) {
        st[barId] = entity.barId
        st[adminId] = entity.adminId
        st[appointed] = entity.appointed
    }

}