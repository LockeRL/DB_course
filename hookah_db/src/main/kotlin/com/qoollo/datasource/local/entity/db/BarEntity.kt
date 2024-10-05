package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class BarEntity(
    val id: UUID? = null,
    val orgId: UUID,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val schedule: String
)
