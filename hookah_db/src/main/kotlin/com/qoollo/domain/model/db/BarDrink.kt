package com.qoollo.domain.model.db

import java.util.UUID

data class BarDrink(
    val id: UUID? = null,
    val barId: UUID,
    val drinkId: UUID,
    val price: Double
)
