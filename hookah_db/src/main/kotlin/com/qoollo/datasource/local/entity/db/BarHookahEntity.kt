package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class BarHookahEntity(
    val id: UUID? = null,
    val barId: UUID,
    val hookahId: UUID,
    val price: Double
)
