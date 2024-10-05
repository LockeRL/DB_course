package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class HookahEntity(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val type: String
)
