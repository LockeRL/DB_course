package com.qoollo.hookah_center.datasource.remote.api

import com.qoollo.hookah_center.datasource.remote.model.BarDto
import com.qoollo.hookah_center.datasource.remote.model.DrinkDto
import com.qoollo.hookah_center.datasource.remote.model.FoodDto
import com.qoollo.hookah_center.datasource.remote.model.HookahDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface BarsApi {
    @GET("/bars")
    suspend fun getBars(): Response<List<BarDto>>

    @GET("/bars/{id}/food")
    suspend fun getFood(@Path("id") barId: UUID): Response<List<FoodDto>>

    @GET("/bars/{id}/drinks")
    suspend fun getDrinks(@Path("id") barId: UUID): Response<List<DrinkDto>>

    @GET("/bars/{id}/hookahs")
    suspend fun getHookahs(@Path("id") barId: UUID): Response<List<HookahDto>>
}