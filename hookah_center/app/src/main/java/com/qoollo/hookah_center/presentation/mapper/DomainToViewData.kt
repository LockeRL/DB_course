package com.qoollo.hookah_center.presentation.mapper

import com.qoollo.hookah_center.domain.model.*
import com.qoollo.hookah_center.presentation.model.*
import java.util.UUID

fun UserInfo.toViewData(): UserInfoViewData = UserInfoViewData(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun User.toInfoViewData(id: UUID) = UserInfoViewData(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun Owner.toViewData(): OwnerViewData = OwnerViewData(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun Bar.toViewData(): BarViewData = BarViewData(
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

fun Food.toViewData(): FoodViewData = FoodViewData(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)

fun Drink.toViewData(): DrinkViewData = DrinkViewData(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun Hookah.toViewData(): HookahViewData = HookahViewData(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)