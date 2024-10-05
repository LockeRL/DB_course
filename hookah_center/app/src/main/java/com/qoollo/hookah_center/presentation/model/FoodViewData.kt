package com.qoollo.hookah_center.presentation.model

import java.util.UUID

data class FoodViewData(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
