package com.qoollo.hookah_center.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "food")
data class FoodEntity(
    @PrimaryKey val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
