package com.qoollo.hookah_center.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
)
