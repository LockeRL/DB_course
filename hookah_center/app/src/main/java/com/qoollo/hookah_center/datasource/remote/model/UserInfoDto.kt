package com.qoollo.hookah_center.datasource.remote.model

import java.util.UUID

data class UserInfoDto(
    val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
)
