package com.qoollo.route.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class CommentInfoRouteModel(
    @Contextual val id: UUID,
    val user: UserInfoRouteModel,
    val score: Short,
    val comment: String
)
