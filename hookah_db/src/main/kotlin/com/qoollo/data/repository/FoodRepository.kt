package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.IFoodDaoService
import com.qoollo.domain.model.db.Food
import com.qoollo.domain.model.info.FoodInfo
import com.qoollo.domain.repository.IFoodRepository
import java.util.*

class FoodRepository(private val service: IFoodDaoService) : IFoodRepository {
    override suspend fun insert(barId: UUID, model: FoodInfo): UUID = service.insert(barId, model)

    override suspend fun insertAll(barId: UUID, modelList: List<FoodInfo>): List<UUID> =
        service.insertAll(barId, modelList)

    override suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<FoodInfo>): List<UUID> =
        service.insertAllInBars(barIds, modelList)

    override suspend fun update(food: FoodInfo) = service.update(food)

    override suspend fun deleteFromBar(barId: UUID, foodId: UUID) = service.delete(barId, foodId)

    override suspend fun deleteFromBars(barIds: List<UUID>, foodId: UUID) = service.delete(barIds, foodId)

    override suspend fun deleteFromAllBars(id: UUID) = service.delete(id)
}