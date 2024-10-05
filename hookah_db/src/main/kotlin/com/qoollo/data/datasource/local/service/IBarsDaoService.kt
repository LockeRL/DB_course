package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.Bar
import java.util.*

interface IBarsDaoService {
    suspend fun insert(model: Bar): UUID
    suspend fun insertAll(modelList: List<Bar>): List<UUID>
    suspend fun read(id: UUID): Bar?
    suspend fun readAll(): List<Bar>
    suspend fun update(id: UUID, model: Bar)
    suspend fun updateAll(modelMap: Map<UUID, Bar>)
    suspend fun delete(id: UUID)
    suspend fun deleteAll()
}