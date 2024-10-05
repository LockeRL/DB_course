package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IOrganizationsDaoService
import com.qoollo.datasource.local.dao.OrganizationsDao
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.Org
import java.util.*

class OrganizationsDaoService(private val dao: OrganizationsDao) : IOrganizationsDaoService {

    override suspend fun insert(model: Org): UUID = dbQuery { dao.insert(model.toEntity()) }

    override suspend fun insertAll(modelList: List<Org>): List<UUID> = dbQuery {
        dao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun read(id: UUID): Org? = dbQuery { dao.read(id)?.toDomain() }

    override suspend fun readAll(): List<Org> = dbQuery {
        dao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Org) = dbQuery { dao.update(id, model.toEntity()) }

    override suspend fun updateAll(modelMap: Map<UUID, Org>) = dbQuery {
        dao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { dao.delete(id) }

    override suspend fun deleteAll() = dbQuery { dao.deleteAll() }
}