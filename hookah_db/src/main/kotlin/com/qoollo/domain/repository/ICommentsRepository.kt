package com.qoollo.domain.repository

import com.qoollo.domain.model.db.Comment
import java.util.*

interface ICommentsRepository {
    suspend fun insert(model: Comment): UUID
    suspend fun update(id: UUID, model: Comment)
    suspend fun delete(id: UUID)
}