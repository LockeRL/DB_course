package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.db.CommentEntity
import com.qoollo.datasource.local.table.CommentsTable

abstract class CommentsDao() : BaseCRUDDao<CommentEntity>(CommentsTable) {
}