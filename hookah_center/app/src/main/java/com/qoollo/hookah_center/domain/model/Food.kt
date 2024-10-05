package com.qoollo.hookah_center.domain.model

import java.util.UUID

data class Food(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
