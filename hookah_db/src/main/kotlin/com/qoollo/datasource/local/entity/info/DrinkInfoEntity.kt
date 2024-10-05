package com.qoollo.datasource.local.entity.info

import java.util.*

data class DrinkInfoEntity(
    val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
