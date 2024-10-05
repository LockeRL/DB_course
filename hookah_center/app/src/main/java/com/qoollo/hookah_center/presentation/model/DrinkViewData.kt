package com.qoollo.hookah_center.presentation.model

import java.util.UUID

data class DrinkViewData(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
