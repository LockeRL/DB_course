package com.qoollo.datasource.local.entity.info

import java.util.*

data class UserInfoEntity(
    val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
)
