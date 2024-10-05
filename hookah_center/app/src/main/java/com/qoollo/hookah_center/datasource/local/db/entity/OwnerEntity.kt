package com.qoollo.hookah_center.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "owner")
data class OwnerEntity(
    @PrimaryKey val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
)
