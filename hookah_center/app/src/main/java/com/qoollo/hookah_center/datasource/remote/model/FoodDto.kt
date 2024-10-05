package com.qoollo.hookah_center.datasource.remote.model

import java.util.UUID

data class FoodDto(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
