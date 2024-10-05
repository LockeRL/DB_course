package com.qoollo.domain.model.db

import java.util.*

data class Comment(
    val id: UUID? = null,
    val barId: UUID,
    val userId: UUID,
    val score: Short,
    val comment: String
)
