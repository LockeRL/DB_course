package com.qoollo.datasource.local.dao

import com.qoollo.datasource.local.entity.info.*
import com.qoollo.datasource.local.mapper.*
import com.qoollo.datasource.local.table.*
import org.jetbrains.exposed.sql.*
import java.util.*

abstract class ComplexDao() {
    private fun getAverageScore(barId: UUID): Float {
        val col = CommentsTable.score.avg().alias(AVG_SCORE)
        return CommentsTable
            .slice(col)
            .select {
                CommentsTable.barId eq barId
            }
            .first()[col]
            ?.toFloat() ?: 0.0f
    }

    private fun getBarInfoEntity(resultRow: ResultRow): BarInfoEntity =
        resultRow.toBarInfoEntity(
            getAverageScore(resultRow[BarsTable.id].value)
        )

    fun getBarsWithScore(): List<BarInfoEntity> =
        (BarsTable innerJoin OrganizationsTable)
            .selectAll()
            .map { res ->
                getBarInfoEntity(res)
            }

    fun getBarWithFood(barId: UUID): List<FoodInfoEntity> =
        (BarsFoodTable innerJoin FoodTable)
            .select {
                BarsFoodTable.barId eq barId
            }.map { res ->
                res.toFoodInfoEntity()
            }

    fun getBarWithHookahs(barId: UUID): List<HookahInfoEntity> =
        (BarsHookahsTable innerJoin HookahsTable)
            .select {
                BarsHookahsTable.barId eq barId
            }.map { res ->
                res.toHookahInfoEntity()
            }

    fun getBarWithDrinks(barId: UUID): List<DrinkInfoEntity> =
        (BarsDrinksTable innerJoin DrinksTable)
            .select {
                BarsDrinksTable.barId eq barId
            }.map { res ->
                res.toDrinkInfoEntity()
            }

    fun getUserInfo(userId: UUID): UserInfoEntity? =
        UsersTable
            .select {
                UsersTable.id eq userId
            }.map { res ->
                res.toUserInfoEntity()
            }.singleOrNull()

    fun getBarComments(barId: UUID): List<CommentInfoEntity> =
        (CommentsTable innerJoin UsersTable)
            .select {
                (CommentsTable.barId eq barId) and
                        (CommentsTable.userId eq UsersTable.id)
            }.map { res ->
                res.toCommentInfoEntity()
            }

    fun getAdministeredBars(adminId: UUID): List<BarInfoEntity> =
        (AdminsBarsTable innerJoin BarsTable innerJoin OrganizationsTable)
            .select {
                (AdminsBarsTable.adminId eq adminId) and
                        (AdminsBarsTable.barId eq BarsTable.id) and
                        (BarsTable.orgId eq OrganizationsTable.id)
            }.map { res ->
                getBarInfoEntity(res)
            }

    companion object {
        private const val AVG_SCORE = "avg_score"
    }
}