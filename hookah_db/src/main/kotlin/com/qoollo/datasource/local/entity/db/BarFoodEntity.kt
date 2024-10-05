package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class BarFoodEntity(
    val id: UUID? = null,
    val barId: UUID,
    val foodId: UUID,
    val price: Double
)
