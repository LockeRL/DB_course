package com.qoollo.domain.model.info

import com.qoollo.domain.model.db.Org
import java.util.*

data class BarInfo(
    val id: UUID,
    val org: Org,
    val score: Float,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val longitude: Double,
    val latitude: Double,
    val schedule: String
)
