package com.qoollo.domain.model.db

import java.util.UUID

data class Hookah(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val type: String
)
