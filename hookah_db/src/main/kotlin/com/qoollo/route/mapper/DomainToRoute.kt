package com.qoollo.route.mapper

import com.qoollo.domain.model.db.*
import com.qoollo.domain.model.info.*
import com.qoollo.route.model.*

fun Org.toRoute(): OrgRouteModel = OrgRouteModel(
    id = id,
    name = name,
    description = description,
    category = category
)

fun UserInfo.toRoute(): UserInfoRouteModel = UserInfoRouteModel(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun BarInfo.toRoute(): BarInfoRouteModel = BarInfoRouteModel(
    id = id,
    org = org.toRoute(),
    score = score,
    name = name,
    phone = phone,
    website = website,
    city = city,
    longitude = longitude,
    latitude = latitude,
    schedule = schedule
)

fun FoodInfo.toRoute(): FoodInfoRouteModel = FoodInfoRouteModel(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)

fun DrinkInfo.toRoute(): DrinkInfoRouteModel = DrinkInfoRouteModel(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun HookahInfo.toRoute(): HookahInfoRouteModel = HookahInfoRouteModel(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)

fun CommentInfo.toRoute(): CommentInfoRouteModel = CommentInfoRouteModel(
    id = id,
    user = user.toRoute(),
    score = score,
    comment = comment
)

fun Admin.toRoute(): AdminRouteModel = AdminRouteModel(
    id = id,
    userId = userId,
    created = created,
    role = role
)