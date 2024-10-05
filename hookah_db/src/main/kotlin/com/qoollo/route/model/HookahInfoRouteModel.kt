package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class HookahInfoRouteModel(
    @Contextual val id: UUID,
    val name: String,
    val description: String,
    val type: String,
    val price: Double
)
