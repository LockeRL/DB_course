package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.Admin
import com.qoollo.domain.model.info.BarInfo
import java.util.*

interface IAdminsDaoService {
    suspend fun insert(model: Admin): UUID
    suspend fun insert(barId: UUID, model: Admin): UUID
    suspend fun insertAll(modelList: List<Admin>): List<UUID>
    suspend fun insertAll(barId: UUID, modelList: List<Admin>): List<UUID>
    suspend fun read(id: UUID): Admin?
    suspend fun readByUserId(userId: UUID): Admin?
    suspend fun readAll(): List<Admin>
    suspend fun update(id: UUID, model: Admin)
    suspend fun updateAll(modelMap: Map<UUID, Admin>)
    suspend fun delete(id: UUID)
    suspend fun delete(barId: UUID, adminId: UUID)
    suspend fun deleteAll()
    suspend fun deleteAllInBar(barId: UUID)
}