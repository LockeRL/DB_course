package com.qoollo.domain.repository

import com.qoollo.domain.model.info.DrinkInfo
import java.util.*

interface IDrinksRepository {
    suspend fun insert(barId: UUID, model: DrinkInfo): UUID
    suspend fun insertAll(barId: UUID, modelList: List<DrinkInfo>): List<UUID>
    suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<DrinkInfo>): List<UUID>
    suspend fun update(drink: DrinkInfo)
    suspend fun deleteFromBar(barId: UUID, drinkId: UUID)
    suspend fun deleteFromBars(barIds: List<UUID>, drinkId: UUID)
    suspend fun deleteFromAllBars(id: UUID)
}