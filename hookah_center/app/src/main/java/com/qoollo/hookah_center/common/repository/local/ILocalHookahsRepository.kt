package com.qoollo.hookah_center.common.repository.local

import com.qoollo.hookah_center.domain.model.Hookah
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface ILocalHookahsRepository {
    suspend fun insert(hookahs: List<Hookah>)
    fun read(): Flow<List<Hookah>>

    fun read(id: UUID): Flow<Hookah?>
}