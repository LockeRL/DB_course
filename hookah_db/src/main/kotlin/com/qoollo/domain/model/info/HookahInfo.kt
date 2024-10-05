package com.qoollo.domain.model.info

import java.util.*

data class HookahInfo(
    val id: UUID,
    val name: String,
    val description: String,
    val type: String,
    val price: Double
)
