package com.qoollo.datasource.local.mapper

import com.qoollo.datasource.local.entity.info.*
import com.qoollo.datasource.local.table.*
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toFoodInfoEntity(): FoodInfoEntity = FoodInfoEntity(
    name = this[FoodTable.name],
    ingredients = this[FoodTable.ingredients],
    price = this[BarsFoodTable.price],
    id = this[FoodTable.id].value
)

fun ResultRow.toBarInfoEntity(score: Float): BarInfoEntity = BarInfoEntity(
    id = this[BarsTable.id].value,
    org = with(OrganizationsTable) { this@toBarInfoEntity.toEntity() } ,
    score = score,
    name = this[BarsTable.name],
    phone = this[BarsTable.phone],
    website = this[BarsTable.website],
    city = this[BarsTable.city],
    longitude = this[BarsTable.longitude],
    latitude = this[BarsTable.latitude],
    schedule = this[BarsTable.schedule]
)

fun ResultRow.toDrinkInfoEntity(): DrinkInfoEntity = DrinkInfoEntity(
    id = this[DrinksTable.id].value,
    name = this[DrinksTable.name],
    ingredients = this[DrinksTable.ingredients],
    type = this[DrinksTable.type],
    price = this[BarsDrinksTable.price]
)

fun ResultRow.toHookahInfoEntity(): HookahInfoEntity = HookahInfoEntity(
    id = this[HookahsTable.id].value,
    name = this[HookahsTable.name],
    description = this[HookahsTable.description],
    type = this[HookahsTable.type],
    price = this[BarsHookahsTable.price]
)

fun ResultRow.toUserInfoEntity(): UserInfoEntity = UserInfoEntity(
    id = this[UsersTable.id].value,
    login = this[UsersTable.login],
    firstName = this[UsersTable.firstName],
    secondName = this[UsersTable.secondName]
)

fun ResultRow.toCommentInfoEntity(): CommentInfoEntity = CommentInfoEntity(
    id = this[CommentsTable.id].value,
    user = this.toUserInfoEntity(),
    score = this[CommentsTable.score],
    comment = this[CommentsTable.comment]
)