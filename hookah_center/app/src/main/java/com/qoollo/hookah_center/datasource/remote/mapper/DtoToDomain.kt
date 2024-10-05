package com.qoollo.hookah_center.datasource.remote.mapper

import com.qoollo.hookah_center.datasource.remote.model.*
import com.qoollo.hookah_center.domain.model.*

fun UserInfoDto.toDomain(): UserInfo = UserInfo(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun UserInfoDto.toOwner(): Owner = Owner(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun BarDto.toDomain(): Bar = Bar(
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

fun DrinkDto.toDomain(): Drink = Drink(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun HookahDto.toDomain(): Hookah = Hookah(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)

fun FoodDto.toDomain(): Food = Food(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)