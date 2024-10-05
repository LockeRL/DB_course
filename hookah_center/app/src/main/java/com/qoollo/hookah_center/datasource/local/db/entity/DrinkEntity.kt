package com.qoollo.hookah_center.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "drinks")
data class DrinkEntity(
    @PrimaryKey val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
