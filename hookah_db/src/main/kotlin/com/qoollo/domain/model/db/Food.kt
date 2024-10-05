package com.qoollo.domain.model.db

import java.util.UUID

data class Food(
    val id: UUID? = null,
    val name: String,
    val ingredients: String
)
