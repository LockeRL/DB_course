package com.qoollo.datasource.local.entity.db

import java.util.*

data class CommentEntity(
    val id: UUID? = null,
    val barId: UUID,
    val userId: UUID,
    val score: Short,
    val comment: String
)
