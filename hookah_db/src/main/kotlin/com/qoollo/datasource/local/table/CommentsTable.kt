package com.qoollo.datasource.local.table

import com.qoollo.datasource.local.entity.db.CommentEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder

object CommentsTable : AbstractTable<CommentEntity>() {
    private const val BAR_ID = "bar_id"
    private const val USER_ID = "user_id"
    private const val SCORE = "score"
    private const val COMMENT = "comment"

    val barId = reference(BAR_ID, BarsTable.id, onDelete = ReferenceOption.CASCADE)
    val userId = reference(USER_ID, UsersTable.id, onDelete = ReferenceOption.CASCADE)
    val score = short(SCORE)
    val comment = text(COMMENT)

    override fun ResultRow.toEntity(): CommentEntity = CommentEntity(
        score = this[score],
        comment = this[comment],
        userId = this[userId].value,
        barId = this[barId].value,
        id = this[id].value
    )

    override fun updateStatement(st: UpdateBuilder<Int>, entity: CommentEntity) {
        st[barId] = entity.barId
        st[userId] = entity.userId
        st[comment] = entity.comment
        st[score] = entity.score
    }
}