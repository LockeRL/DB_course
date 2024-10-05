package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class DrinkInfoRouteModel(
    @Contextual val id: UUID,
    val name: String,
    val ingredients: String,
    val type: String,
    val price: Double
)
