package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.IHookahsDaoService
import com.qoollo.domain.model.db.Hookah
import com.qoollo.domain.model.info.HookahInfo
import com.qoollo.domain.repository.IHookahsRepository
import java.util.*

class HookahsRepository(private val service: IHookahsDaoService) : IHookahsRepository {
    override suspend fun insert(barId: UUID, model: HookahInfo): UUID = service.insert(barId, model)

    override suspend fun insertAll(barId: UUID, modelList: List<HookahInfo>): List<UUID> =
        service.insertAll(barId, modelList)

    override suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<HookahInfo>): List<UUID> =
        service.insertAllInBars(barIds, modelList)

    override suspend fun update(hookah: HookahInfo) = service.update(hookah)

    override suspend fun deleteFromBar(barId: UUID, hookahId: UUID) = service.delete(barId, hookahId)

    override suspend fun deleteFromBars(barIds: List<UUID>, hookahId: UUID) = service.delete(barIds, hookahId)

    override suspend fun deleteFromAllBars(id: UUID) = service.delete(id)
}