package com.qoollo.domain.model.info

import java.util.*

data class UserInfo(
    val id: UUID? = null,
    val login: String,
    val firstName: String,
    val secondName: String
)
