package com.qoollo.datasource.local.entity.info

import java.util.UUID

data class FoodInfoEntity(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
