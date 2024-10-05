package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class UserEntity(
    val id: UUID? = null,
    val login: String,
    val password: String,
    val firstName: String,
    val secondName: String
)
