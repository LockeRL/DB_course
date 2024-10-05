package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class BarRouteModel(
    @Contextual val id: UUID? = null,
    @Contextual val orgId: UUID,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val schedule: String
)
