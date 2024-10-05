package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class BarDrinkEntity(
    val id: UUID? = null,
    val barId: UUID,
    val drinkId: UUID,
    val price: Double
)
