package com.qoollo.datasource.local.mapper

import com.qoollo.datasource.local.entity.db.*
import com.qoollo.domain.model.db.*
import com.qoollo.domain.model.info.DrinkInfo
import com.qoollo.domain.model.info.FoodInfo
import com.qoollo.domain.model.info.HookahInfo

fun Admin.toEntity(): AdminEntity = AdminEntity(
    created = created,
    role = role,
    userId = userId
)

fun AdminBar.toEntity(): AdminBarEntity = AdminBarEntity(
    barId = barId,
    adminId = adminId,
    appointed = appointed
)

fun Org.toEntity(): OrgEntity = OrgEntity(
    name = name,
    description = description,
    category = category
)

fun Bar.toEntity(): BarEntity = BarEntity(
    orgId = orgId,
    name = name,
    phone = phone,
    website = website,
    city = city,
    latitude = latitude,
    longitude = longitude,
    schedule = schedule
)

fun BarDrink.toEntity(): BarDrinkEntity = BarDrinkEntity(
    barId = barId,
    drinkId = drinkId,
    price = price
)

fun BarFood.toEntity(): BarFoodEntity = BarFoodEntity(
    barId = barId,
    foodId = foodId,
    price = price
)

fun BarHookah.toEntity(): BarHookahEntity = BarHookahEntity(
    barId = barId,
    hookahId = hookahId,
    price = price
)

fun Comment.toEntity(): CommentEntity = CommentEntity(
    barId = barId,
    userId = userId,
    score = score,
    comment = comment
)

fun Drink.toEntity(): DrinkEntity = DrinkEntity(
    name = name,
    ingredients = ingredients,
    type = type
)

fun Food.toEntity(): FoodEntity = FoodEntity(
    name = name,
    ingredients = ingredients
)

fun Hookah.toEntity(): HookahEntity = HookahEntity(
    name = name,
    description = description,
    type = type
)

fun User.toEntity(): UserEntity = UserEntity(
    login = login,
    password = password,
    firstName = firstName,
    secondName = secondName
)

fun FoodInfo.toEntity(): FoodEntity = FoodEntity(
    name = name,
    ingredients = ingredients
)

fun DrinkInfo.toEntity(): DrinkEntity = DrinkEntity(
    name = name,
    ingredients = ingredients,
    type = type
)

fun HookahInfo.toEntity(): HookahEntity = HookahEntity(
    name = name,
    description = description,
    type = type
)