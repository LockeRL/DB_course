package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.ICommentsDaoService
import com.qoollo.domain.model.db.Comment
import com.qoollo.domain.repository.ICommentsRepository
import java.util.*

class CommentsRepository(private val service: ICommentsDaoService) : ICommentsRepository {
    override suspend fun insert(model: Comment): UUID = service.insert(model)

    override suspend fun update(id: UUID, model: Comment) = service.update(id, model)

    override suspend fun delete(id: UUID) = service.delete(id)
}