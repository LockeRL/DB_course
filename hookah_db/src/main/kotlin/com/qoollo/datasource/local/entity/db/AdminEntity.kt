package com.qoollo.datasource.local.entity.db

import java.util.*

data class AdminEntity(
    val id: UUID? = null,
    val userId: UUID,
    val created: String,
    val role: String
)
