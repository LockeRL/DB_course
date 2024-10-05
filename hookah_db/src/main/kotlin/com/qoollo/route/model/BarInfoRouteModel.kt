package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class BarInfoRouteModel(
    @Contextual val id: UUID,
    val org: OrgRouteModel,
    val score: Float,
    val name: String,
    val phone: String,
    val website: String,
    val city: String,
    val longitude: Double,
    val latitude: Double,
    val schedule: String
)
