package com.qoollo.hookah_center.presentation.model

import java.util.UUID

data class HookahViewData(
    val id: UUID,
    val name: String,
    val description: String,
    val type: String,
    val price: Double
)
