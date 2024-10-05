package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.AdminEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object AdminsTable : AbstractTable<AdminEntity>() {
    private const val CREATED = "created"
    private const val CREATED_LENGTH = 20
    private const val ROLE = "role"
    private const val ROLE_LENGTH = 10
    private const val USER_ID = "user_id"

    val userId = reference(USER_ID, UsersTable, onDelete = ReferenceOption.CASCADE)
    val created = varchar(CREATED, length = CREATED_LENGTH)
    val role = varchar(ROLE, length = ROLE_LENGTH)

    override fun ResultRow.toEntity(): AdminEntity = AdminEntity(
        created = this[created],
        role = this[role],
        id = this[id].value,
        userId = this[userId].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: AdminEntity) {
        st[created] = entity.created
        st[role] = entity.role
        st[userId] = entity.userId
    }
}