package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrgRouteModel(
    @Contextual val id: UUID? = null,
    val name: String,
    val description: String,
    val category: String
)
