package com.qoollo.domain.model.db

import java.util.UUID

data class BarHookah(
    val id: UUID? = null,
    val barId: UUID,
    val hookahId: UUID,
    val price: Double
)
