package com.qoollo.hookah_center.datasource.local.db.mapper

import com.qoollo.hookah_center.datasource.local.db.entity.*
import com.qoollo.hookah_center.domain.model.*


fun UserInfo.toEntity(): UserEntity = UserEntity(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun Owner.toEntity(): OwnerEntity = OwnerEntity(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun Bar.toEntity(): BarEntity = BarEntity(
    id = id,
    score = score,
    name = name,
    phone = phone,
    website = website,
    city = city,
    longitude = longitude,
    latitude = latitude,
    schedule = schedule
)

fun Food.toEntity(): FoodEntity = FoodEntity(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)

fun Drink.toEntity(): DrinkEntity = DrinkEntity(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun Hookah.toEntity(): HookahEntity = HookahEntity(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)