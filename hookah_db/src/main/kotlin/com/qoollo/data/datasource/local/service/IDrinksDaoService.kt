package com.qoollo.data.datasource.local.service

import com.qoollo.domain.model.db.Drink
import com.qoollo.domain.model.info.DrinkInfo
import java.util.*

interface IDrinksDaoService {
    suspend fun insert(model: Drink): UUID
    suspend fun insert(barId: UUID, model: DrinkInfo): UUID
    suspend fun insertAll(modelList: List<Drink>): List<UUID>
    suspend fun insertAll(barId: UUID, modelList: List<DrinkInfo>): List<UUID>
    suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<DrinkInfo>): List<UUID>
    suspend fun read(id: UUID): Drink?
    suspend fun readAll(): List<Drink>
    suspend fun update(id: UUID, model: Drink)
    suspend fun update(drink: DrinkInfo)
    suspend fun updateAll(modelMap: Map<UUID, Drink>)
    suspend fun delete(id: UUID)
    suspend fun delete(barId: UUID, drinkId: UUID)
    suspend fun delete(barsId: List<UUID>, drinkId: UUID)
    suspend fun deleteAll()
}