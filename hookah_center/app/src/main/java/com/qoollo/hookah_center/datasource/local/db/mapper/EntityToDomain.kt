package com.qoollo.hookah_center.datasource.local.db.mapper

import com.qoollo.hookah_center.datasource.local.db.entity.*
import com.qoollo.hookah_center.domain.model.*


fun UserEntity.toDomain(): UserInfo = UserInfo(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun OwnerEntity.toDomain(): Owner = Owner(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun BarEntity.toDomain(): Bar = Bar(
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

fun HookahEntity.toDomain(): Hookah = Hookah(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)

fun DrinkEntity.toDomain(): Drink = Drink(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun FoodEntity.toDomain(): Food = Food(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)