package com.qoollo.hookah_center.common.repository.local

import com.qoollo.hookah_center.domain.model.Food
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface ILocalFoodRepository {
    suspend fun insert(food: List<Food>)
    fun read(): Flow<List<Food>>

    fun read(id: UUID): Flow<Food?>
}