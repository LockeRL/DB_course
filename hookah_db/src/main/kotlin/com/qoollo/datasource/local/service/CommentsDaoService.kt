package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.ICommentsDaoService
import com.qoollo.datasource.local.dao.CommentsDao
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.Comment
import java.util.*

class CommentsDaoService(private val dao: CommentsDao) : ICommentsDaoService {

    override suspend fun insert(model: Comment): UUID = dbQuery { dao.insert(model.toEntity()) }

    override suspend fun insertAll(modelList: List<Comment>): List<UUID> = dbQuery {
        dao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun read(id: UUID): Comment? = dbQuery { dao.read(id)?.toDomain() }

    override suspend fun readAll(): List<Comment> = dbQuery {
        dao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Comment) = dbQuery { dao.update(id, model.toEntity()) }

    override suspend fun updateAll(modelMap: Map<UUID, Comment>) = dbQuery {
        dao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { dao.delete(id) }

    override suspend fun deleteAll() = dbQuery { dao.deleteAll() }
}