package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UserRouteModel(
    @Contextual val id: UUID? = null,
    val login: String,
    val password: String,
    val firstName: String,
    val secondName: String
)
