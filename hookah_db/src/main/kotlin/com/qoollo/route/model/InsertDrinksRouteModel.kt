package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class InsertDrinksRouteModel(
    val bars: List<@Contextual UUID>,
    val drinks: List<DrinkInfoRouteModel>
)
