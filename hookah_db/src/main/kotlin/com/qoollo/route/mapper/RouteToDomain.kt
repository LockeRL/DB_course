package com.qoollo.route.mapper

import com.qoollo.domain.model.db.*
import com.qoollo.domain.model.info.DrinkInfo
import com.qoollo.domain.model.info.FoodInfo
import com.qoollo.domain.model.info.HookahInfo
import com.qoollo.route.model.*
import com.qoollo.route.model.DrinkInfoRouteModel
import com.qoollo.route.model.FoodInfoRouteModel
import com.qoollo.route.model.HookahInfoRouteModel

fun OrgRouteModel.toDomain(): Org = Org(
    name = name,
    description = description,
    category = category
)

fun UserRouteModel.toDomain(): User = User(
    id = id,
    login = login,
    password = password,
    firstName = firstName,
    secondName = secondName
)

fun CommentRouteModel.toDomain(): Comment = Comment(
    id = id,
    barId = barId,
    userId = userId,
    score = score,
    comment = comment
)

fun AdminRouteModel.toDomain(): Admin = Admin(
    id = id,
    created = created,
    role = role,
    userId = userId
)

fun BarRouteModel.toDomain(): Bar = Bar(
    id = id,
    orgId = orgId,
    name = name,
    phone = phone,
    website = website,
    city = city,
    latitude = latitude,
    longitude = longitude,
    schedule = schedule
)

fun FoodInfoRouteModel.toDomain(): FoodInfo = FoodInfo(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)

fun DrinkInfoRouteModel.toDomain(): DrinkInfo = DrinkInfo(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun HookahInfoRouteModel.toDomain(): HookahInfo = HookahInfo(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)