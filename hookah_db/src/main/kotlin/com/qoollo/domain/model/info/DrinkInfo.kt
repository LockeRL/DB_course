package com.qoollo.domain.model.info

import java.util.*

data class DrinkInfo(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
