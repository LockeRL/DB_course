package com.qoollo.domain.model.db

import java.util.UUID

data class Drink(
    val id: UUID? = null,
    val name: String,
    val ingredients: String,
    val type: String
)
