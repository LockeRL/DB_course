package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.table.AbstractTable
import com.qoollo.datasource.local.util.dbQuery
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

abstract class BaseCRUDDao<T>(private val DBTable: AbstractTable<T>) {

    fun insert(entity: T): UUID =
        DBTable.insert { insertStatement ->
            DBTable.updateStatement(insertStatement, entity)
        }[DBTable.id]
            .value

    fun insertAll(entityList: List<T>): List<UUID> =
        DBTable.batchInsert(entityList) { entity ->
            DBTable.updateStatement(this, entity)
        }
            .map { res ->
                res[DBTable.id].value
            }

    fun read(id: UUID): T? =
        DBTable.select { DBTable.id eq id }
            .map { res ->
                with(DBTable) {
                    res.toEntity()
                }
            }
            .singleOrNull()

    fun readAll(): List<T> =
        DBTable.selectAll()
            .map { res ->
                with(DBTable) {
                    res.toEntity()
                }
            }

    fun update(id: UUID, entity: T) {
        DBTable.update({ DBTable.id eq id }) { updateStatement ->
            DBTable.updateStatement(updateStatement, entity)
        }
    }

    fun updateAll(entityMap: Map<UUID, T>) {
        transaction {
            entityMap.forEach { (id, entity) ->
                DBTable.update({ DBTable.id eq id }) { updateStatement ->
                    DBTable.updateStatement(updateStatement, entity)
                }
            }
        }
    }

    fun delete(id: UUID) {
        DBTable.deleteWhere { DBTable.id eq id }
    }

    fun deleteAll() {
        DBTable.deleteAll()
    }

}