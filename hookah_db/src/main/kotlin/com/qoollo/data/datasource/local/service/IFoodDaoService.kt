package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.Food
import com.qoollo.domain.model.info.FoodInfo
import java.util.*

interface IFoodDaoService {
    suspend fun insert(model: Food): UUID
    suspend fun insert(barId: UUID, model: FoodInfo): UUID
    suspend fun insertAll(modelList: List<Food>): List<UUID>
    suspend fun insertAll(barId: UUID, modelList: List<FoodInfo>): List<UUID>
    suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<FoodInfo>): List<UUID>
    suspend fun read(id: UUID): Food?
    suspend fun readAll(): List<Food>
    suspend fun update(id: UUID, model: Food)
    suspend fun update(food: FoodInfo)
    suspend fun updateAll(modelMap: Map<UUID, Food>)
    suspend fun delete(id: UUID)
    suspend fun delete(barId: UUID, foodId: UUID)
    suspend fun delete(barsId: List<UUID>, foodId: UUID)
    suspend fun deleteAll()
}