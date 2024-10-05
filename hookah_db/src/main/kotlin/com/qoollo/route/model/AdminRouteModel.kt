package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class AdminRouteModel(
    @Contextual val id: UUID? = null,
    @SerialName("user_id") @Contextual val userId: UUID,
    val created: String,
    val role: String
)
