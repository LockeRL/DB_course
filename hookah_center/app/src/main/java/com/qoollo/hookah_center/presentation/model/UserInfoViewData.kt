package com.qoollo.hookah_center.presentation.model

import java.io.Serializable
import java.util.UUID

data class UserInfoViewData(
    val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
) : Serializable
