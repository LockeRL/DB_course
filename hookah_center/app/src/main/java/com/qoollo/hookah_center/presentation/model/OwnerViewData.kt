package com.qoollo.hookah_center.presentation.model

import java.util.UUID

data class OwnerViewData(
    val id: UUID,
    val login: String,
    val firstName: String,
    val secondName: String
)
