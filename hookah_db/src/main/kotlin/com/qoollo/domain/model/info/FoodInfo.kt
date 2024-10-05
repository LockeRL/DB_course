package com.qoollo.domain.model.info

import java.util.UUID

data class FoodInfo(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
