package com.qoollo.domain.model.db

import java.util.*

data class Admin(
    val id: UUID? = null,
    val userId: UUID,
    val created: String,
    val role: String
)
