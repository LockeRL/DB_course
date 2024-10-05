package com.qoollo.route.model

import kotlinx.serialization.Serializable

@Serializable
data class AdminInfoRouteModel(
    val admin: AdminRouteModel,
    val user: UserInfoRouteModel
)
