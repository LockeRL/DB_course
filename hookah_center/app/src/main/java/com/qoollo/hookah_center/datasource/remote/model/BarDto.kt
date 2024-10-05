package com.qoollo.hookah_center.datasource.remote.model

import java.util.UUID

data class BarDto(
    val id: UUID,
    val score: Float,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val longitude: Double,
    val latitude: Double,
    val schedule: String
)
