package com.qoollo.datasource.local.entity.info

import java.util.*

data class HookahInfoEntity(
    val id: UUID,
    val name: String,
    val description: String,
    val type: String,
    val price: Double
)
