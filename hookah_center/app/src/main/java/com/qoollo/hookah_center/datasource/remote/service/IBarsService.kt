package com.qoollo.hookah_center.datasource.remote.service

import com.qoollo.hookah_center.datasource.remote.model.BarDto
import com.qoollo.hookah_center.datasource.remote.model.DrinkDto
import com.qoollo.hookah_center.datasource.remote.model.FoodDto
import com.qoollo.hookah_center.datasource.remote.model.HookahDto
import java.util.UUID

interface IBarsService {
    suspend fun getBars(): Result<List<BarDto>>
    suspend fun getFood(barId: UUID): Result<List<FoodDto>>
    suspend fun getDrinks(barId: UUID): Result<List<DrinkDto>>
    suspend fun getHookahs(barId: UUID): Result<List<HookahDto>>
}