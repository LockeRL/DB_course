package com.qoollo.domain.model.db

import java.util.UUID

data class User(
    val id: UUID? = null,
    val login: String,
    val password: String,
    val firstName: String,
    val secondName: String
)
