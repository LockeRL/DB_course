package com.qoollo.domain.model.info

import java.util.*

data class CommentInfo(
    val id: UUID,
    val user: UserInfo,
    val score: Short,
    val comment: String
)
