package com.qoollo.hookah_center.presentation.model

import java.util.UUID

data class BarViewData(
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