package com.qoollo.hookah_center.domain.model

import java.util.UUID

data class Owner(
    val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
)