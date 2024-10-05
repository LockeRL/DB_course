package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class CommentRouteModel(
    @Contextual val id: UUID? = null,
    @Contextual val barId: UUID,
    @Contextual val userId: UUID,
    val score: Short,
    val comment: String
)
