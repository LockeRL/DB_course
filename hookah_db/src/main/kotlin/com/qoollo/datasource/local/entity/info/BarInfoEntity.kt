package com.qoollo.datasource.local.entity.info

import com.qoollo.datasource.local.entity.db.OrgEntity
import java.util.*

data class BarInfoEntity(
    val id: UUID,
    val org: OrgEntity,
    val score: Float,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val longitude: Double,
    val latitude: Double,
    val schedule: String
)
