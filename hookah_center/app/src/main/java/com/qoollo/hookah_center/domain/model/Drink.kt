package com.qoollo.hookah_center.domain.model

import java.util.UUID

data class Drink(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
