package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.IDrinksDaoService
import com.qoollo.domain.model.db.Drink
import com.qoollo.domain.model.info.DrinkInfo
import com.qoollo.domain.repository.IDrinksRepository
import java.util.*

class DrinksRepository(private val drinksService: IDrinksDaoService) : IDrinksRepository {
    override suspend fun insert(barId: UUID, model: DrinkInfo): UUID = drinksService.insert(barId, model)

    override suspend fun insertAll(barId: UUID, modelList: List<DrinkInfo>): List<UUID> =
        drinksService.insertAll(barId, modelList)

    override suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<DrinkInfo>): List<UUID> =
        drinksService.insertAllInBars(barIds, modelList)

    override suspend fun update(drink: DrinkInfo) = drinksService.update(drink)

    override suspend fun deleteFromBar(barId: UUID, drinkId: UUID) = drinksService.delete(barId, drinkId)

    override suspend fun deleteFromBars(barIds: List<UUID>, drinkId: UUID) = drinksService.delete(barIds, drinkId)

    override suspend fun deleteFromAllBars(id: UUID) = drinksService.delete(id)
}