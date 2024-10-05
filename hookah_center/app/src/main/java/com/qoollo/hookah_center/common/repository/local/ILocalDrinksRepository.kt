package com.qoollo.hookah_center.common.repository.local

import com.qoollo.hookah_center.domain.model.Drink
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface ILocalDrinksRepository {
    suspend fun insert(drinks: List<Drink>)
    fun read(): Flow<List<Drink>>

    fun read(id: UUID): Flow<Drink?>
}