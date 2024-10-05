package com.qoollo.hookah_center.datasource.remote.model

import java.util.UUID

data class DrinkDto(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
