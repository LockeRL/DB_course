package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class DrinkEntity(
    val id: UUID? = null,
    val name: String,
    val ingredients: String,
    val type: String
)
