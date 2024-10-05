package com.qoollo.domain.model.db

import java.util.UUID

data class Org(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val category: String
)
