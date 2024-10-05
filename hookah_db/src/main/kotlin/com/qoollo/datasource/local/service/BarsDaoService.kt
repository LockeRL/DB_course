package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IBarsDaoService
import com.qoollo.datasource.local.dao.BarsDao
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.Bar
import java.util.*

class BarsDaoService(private val dao: BarsDao) : IBarsDaoService {

    override suspend fun insert(model: Bar): UUID = dbQuery { dao.insert(model.toEntity()) }

    override suspend fun insertAll(modelList: List<Bar>): List<UUID> = dbQuery {
        dao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun read(id: UUID): Bar? = dbQuery { dao.read(id)?.toDomain() }

    override suspend fun readAll(): List<Bar> = dbQuery {
        dao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Bar) = dbQuery { dao.update(id, model.toEntity()) }

    override suspend fun updateAll(modelMap: Map<UUID, Bar>) = dbQuery {
        dao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { dao.delete(id) }

    override suspend fun deleteAll() = dbQuery { dao.deleteAll() }
}