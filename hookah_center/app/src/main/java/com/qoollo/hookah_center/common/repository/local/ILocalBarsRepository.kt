package com.qoollo.hookah_center.common.repository.local

import com.qoollo.hookah_center.domain.model.Bar
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface ILocalBarsRepository {
    suspend fun insert(bars: List<Bar>)
    fun read(): Flow<List<Bar>>
    fun read(id: UUID): Flow<Bar?>
}