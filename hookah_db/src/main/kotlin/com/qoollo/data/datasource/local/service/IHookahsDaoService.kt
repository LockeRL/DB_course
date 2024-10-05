package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.Hookah
import com.qoollo.domain.model.info.HookahInfo
import java.util.*

interface IHookahsDaoService {
    suspend fun insert(model: Hookah): UUID
    suspend fun insert(barId: UUID, model: HookahInfo): UUID
    suspend fun insertAll(modelList: List<Hookah>): List<UUID>
    suspend fun insertAll(barId: UUID, modelList: List<HookahInfo>): List<UUID>
    suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<HookahInfo>): List<UUID>
    suspend fun read(id: UUID): Hookah?
    suspend fun readAll(): List<Hookah>
    suspend fun update(id: UUID, model: Hookah)
    suspend fun update(hookah: HookahInfo)
    suspend fun updateAll(modelMap: Map<UUID, Hookah>)
    suspend fun delete(id: UUID)
    suspend fun delete(barId: UUID, hookahId: UUID)
    suspend fun delete(barsId: List<UUID>, hookahId: UUID)
    suspend fun deleteAll()
}