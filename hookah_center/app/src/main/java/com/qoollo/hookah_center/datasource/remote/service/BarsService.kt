package com.qoollo.hookah_center.datasource.remote.service

import com.qoollo.hookah_center.datasource.remote.api.BarsApi
import com.qoollo.hookah_center.datasource.remote.mapper.toResult
import com.qoollo.hookah_center.datasource.remote.model.BarDto
import com.qoollo.hookah_center.datasource.remote.model.DrinkDto
import com.qoollo.hookah_center.datasource.remote.model.FoodDto
import com.qoollo.hookah_center.datasource.remote.model.HookahDto
import com.qoollo.hookah_center.datasource.remote.util.runNetworkRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class BarsService(
    private val retrofit: BarsApi,
    private val dispatchers: CoroutineDispatcher = Dispatchers.IO
) : IBarsService {
    override suspend fun getBars(): Result<List<BarDto>> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.getBars().toResult()
            }
        }

    override suspend fun getFood(barId: UUID): Result<List<FoodDto>> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.getFood(barId).toResult()
            }
        }

    override suspend fun getDrinks(barId: UUID): Result<List<DrinkDto>> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.getDrinks(barId).toResult()
            }
        }

    override suspend fun getHookahs(barId: UUID): Result<List<HookahDto>> =
        withContext(dispatchers) {
            runNetworkRequest {
                retrofit.getHookahs(barId).toResult()
            }
        }
}