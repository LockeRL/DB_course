package com.qoollo.hookah_center.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "bars")
data class BarEntity(
    @PrimaryKey val id: UUID,
    val score: Float,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val longitude: Double,
    val latitude: Double,
    val schedule: String
)
