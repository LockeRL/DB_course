package com.qoollo.datasource.local.table

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

abstract class AbstractTable<T> : UUIDTable() {
    abstract fun ResultRow.toEntity(): T

    abstract fun updateStatement(st: UpdateBuilder<Int>, entity: T)

    companion object {
        private const val ID = "id"
    }
}