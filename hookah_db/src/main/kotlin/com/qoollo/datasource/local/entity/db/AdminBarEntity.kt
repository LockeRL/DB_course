package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class AdminBarEntity(
    val id: UUID? = null,
    val barId: UUID,
    val adminId: UUID,
    val appointed: String
)
