package com.qoollo.hookah_center.datasource.remote.model

import java.util.UUID

data class HookahDto(
    val id: UUID,
    val name: String,
    val description: String,
    val type: String,
    val price: Double
)
