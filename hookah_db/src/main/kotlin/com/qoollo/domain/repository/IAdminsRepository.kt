package com.qoollo.domain.repository

import com.qoollo.domain.model.db.Admin
import com.qoollo.domain.model.info.BarInfo
import java.util.*

interface IAdminsRepository {
    suspend fun insert(barId: UUID, model: Admin): UUID
    suspend fun insertAll(barId: UUID, modelList: List<Admin>): List<UUID>
    suspend fun read(userId: UUID): Admin?
    suspend fun update(id: UUID, model: Admin)
    suspend fun delete(id: UUID)
    suspend fun delete(barId: UUID, adminId: UUID)
    suspend fun deleteAllInBar(barId: UUID)
    suspend fun getAdministeredBars(adminId: UUID): List<BarInfo>
}