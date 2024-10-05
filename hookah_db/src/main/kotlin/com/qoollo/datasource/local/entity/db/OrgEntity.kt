package com.qoollo.datasource.local.entity.db

import java.util.UUID

data class OrgEntity(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val category: String
)
