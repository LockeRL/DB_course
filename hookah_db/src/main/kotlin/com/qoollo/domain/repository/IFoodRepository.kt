package com.qoollo.domain.repository

import com.qoollo.domain.model.info.FoodInfo
import java.util.*

interface IFoodRepository {
    suspend fun insert(barId: UUID, model: FoodInfo): UUID
    suspend fun insertAll(barId: UUID, modelList: List<FoodInfo>): List<UUID>
    suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<FoodInfo>): List<UUID>
    suspend fun update(food: FoodInfo)
    suspend fun deleteFromBar(barId: UUID, foodId: UUID)
    suspend fun deleteFromBars(barIds: List<UUID>, foodId: UUID)
    suspend fun deleteFromAllBars(id: UUID)
}