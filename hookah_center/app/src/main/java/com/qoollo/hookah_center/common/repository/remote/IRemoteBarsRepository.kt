package com.qoollo.hookah_center.common.repository.remote

import com.qoollo.hookah_center.domain.model.*
import java.util.UUID

interface IRemoteBarsRepository {
    suspend fun getBars(): Result<List<Bar>>
    suspend fun getFood(barId: UUID): Result<List<Food>>
    suspend fun getDrinks(barId: UUID): Result<List<Drink>>
    suspend fun getHookahs(barId: UUID): Result<List<Hookah>>
}