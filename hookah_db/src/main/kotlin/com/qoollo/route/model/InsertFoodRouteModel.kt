package com.qoollo.route.model

import kotlinx.serialization.Contextual
import java.util.UUID

data class InsertFoodRouteModel(
    val bars: List<@Contextual UUID>,
    val food: List<FoodInfoRouteModel>
)
