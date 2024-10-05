package com.qoollo.route.model

import kotlinx.serialization.Contextual
import java.util.UUID

data class InsertHookahsRouteModel(
    val bars: List<@Contextual UUID>,
    val hookahs: List<HookahInfoRouteModel>
)
