package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.Org
import java.util.*

interface IOrganizationsDaoService {
    suspend fun insert(model: Org): UUID
    suspend fun insertAll(modelList: List<Org>): List<UUID>
    suspend fun read(id: UUID): Org?
    suspend fun readAll(): List<Org>
    suspend fun update(id: UUID, model: Org)
    suspend fun updateAll(modelMap: Map<UUID, Org>)
    suspend fun delete(id: UUID)
    suspend fun deleteAll()
}