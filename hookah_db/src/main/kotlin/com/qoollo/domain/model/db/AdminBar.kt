package com.qoollo.domain.model.db

import java.util.UUID

data class AdminBar(
    val id: UUID? = null,
    val barId: UUID,
    val adminId: UUID,
    val appointed: String
)
