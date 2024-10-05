package com.qoollo.datasource.local.entity.info

import java.util.*

data class CommentInfoEntity(
    val id: UUID,
    val user: UserInfoEntity,
    val score: Short,
    val comment: String
)
