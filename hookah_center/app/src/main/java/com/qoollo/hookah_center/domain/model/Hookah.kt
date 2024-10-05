package com.qoollo.hookah_center.domain.model

import java.util.UUID

data class Hookah(
    val id: UUID,
    val name: String,
    val description: String,
    val type: String,
    val price: Double
)
