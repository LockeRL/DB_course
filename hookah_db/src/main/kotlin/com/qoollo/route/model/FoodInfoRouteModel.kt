package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class FoodInfoRouteModel(
    @Contextual val id: UUID,
    val name: String,
    val ingredients: String,
    val price: Double
)
