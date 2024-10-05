package com.qoollo.domain.repository

import com.qoollo.domain.model.info.HookahInfo
import java.util.*

interface IHookahsRepository {
    suspend fun insert(barId: UUID, model: HookahInfo): UUID
    suspend fun insertAll(barId: UUID, modelList: List<HookahInfo>): List<UUID>
    suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<HookahInfo>): List<UUID>
    suspend fun update(hookah: HookahInfo)
    suspend fun deleteFromBar(barId: UUID, hookahId: UUID)
    suspend fun deleteFromBars(barIds: List<UUID>, hookahId: UUID)
    suspend fun deleteFromAllBars(id: UUID)
}