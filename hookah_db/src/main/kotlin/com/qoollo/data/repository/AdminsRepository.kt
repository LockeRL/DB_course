package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.IAdminsDaoService
import com.qoollo.data.datasource.local.service.IComplexDaoService
import com.qoollo.domain.model.db.Admin
import com.qoollo.domain.model.info.BarInfo
import com.qoollo.domain.repository.IAdminsRepository
import java.util.*


class AdminsRepository(
    private val adminsService: IAdminsDaoService,
    private val complexService: IComplexDaoService
) : IAdminsRepository {
    override suspend fun insert(barId: UUID, model: Admin): UUID = adminsService.insert(barId, model)

    override suspend fun insertAll(barId: UUID, modelList: List<Admin>): List<UUID> =
        adminsService.insertAll(barId, modelList)

    override suspend fun read(userId: UUID): Admin? = adminsService.readByUserId(userId)

    override suspend fun update(id: UUID, model: Admin) = adminsService.update(id, model)

    override suspend fun delete(id: UUID) = adminsService.delete(id)

    override suspend fun delete(barId: UUID, adminId: UUID) = adminsService.delete(barId, adminId)

    override suspend fun deleteAllInBar(barId: UUID) = adminsService.deleteAllInBar(barId)

    override suspend fun getAdministeredBars(adminId: UUID): List<BarInfo> = complexService.getAdministeredBars(adminId)
}