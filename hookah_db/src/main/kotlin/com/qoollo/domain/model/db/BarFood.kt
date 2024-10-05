package com.qoollo.domain.model.db

import java.util.UUID

data class BarFood(
    val id: UUID? = null,
    val barId: UUID,
    val foodId: UUID,
    val price: Double
)
