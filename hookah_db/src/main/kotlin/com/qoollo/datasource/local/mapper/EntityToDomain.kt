package com.qoollo.datasource.local.mapper

import com.qoollo.datasource.local.entity.db.*
import com.qoollo.datasource.local.entity.info.*
import com.qoollo.domain.model.info.*
import com.qoollo.domain.model.db.*

fun AdminEntity.toDomain(): Admin = Admin(
    id = id,
    created = created,
    role = role,
    userId = userId
)

fun AdminBarEntity.toDomain(): AdminBar = AdminBar(
    id = id,
    barId = barId,
    adminId = adminId,
    appointed = appointed
)

fun OrgEntity.toDomain(): Org = Org(
    id = id,
    name = name,
    description = description,
    category = category
)

fun BarEntity.toDomain(): Bar = Bar(
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

fun BarDrinkEntity.toDomain(): BarDrink = BarDrink(
    id = id,
    barId = barId,
    drinkId = drinkId,
    price = price
)

fun BarFoodEntity.toDomain(): BarFood = BarFood(
    id = id,
    barId = barId,
    foodId = foodId,
    price = price
)

fun BarHookahEntity.toDomain(): BarHookah = BarHookah(
    id = id,
    barId = barId,
    hookahId = hookahId,
    price = price
)

fun CommentEntity.toDomain(): Comment = Comment(
    id = id,
    barId = barId,
    userId = userId,
    score = score,
    comment = comment
)

fun DrinkEntity.toDomain(): Drink = Drink(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type
)

fun FoodEntity.toDomain(): Food = Food(
    id = id,
    name = name,
    ingredients = ingredients
)

fun HookahEntity.toDomain(): Hookah = Hookah(
    id = id,
    name = name,
    description = description,
    type = type
)

fun UserEntity.toDomain(): User = User(
    id = id,
    login = login,
    password = password,
    firstName = firstName,
    secondName = secondName
)

fun BarInfoEntity.toDomain(): BarInfo = BarInfo(
    id = id,
    org = org.toDomain(),
    score = score,
    name = name,
    phone = phone,
    website = website,
    city = city,
    longitude = longitude,
    latitude = latitude,
    schedule = schedule
)

fun UserInfoEntity.toDomain(): UserInfo = UserInfo(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun CommentInfoEntity.toDomain(): CommentInfo = CommentInfo(
    id = id,
    user = user.toDomain(),
    score = score,
    comment = comment
)

fun DrinkInfoEntity.toDomain(): DrinkInfo = DrinkInfo(
    id = id,
    name = name,
    ingredients = ingredients,
    type = type,
    price = price
)

fun FoodInfoEntity.toDomain(): FoodInfo = FoodInfo(
    id = id,
    name = name,
    ingredients = ingredients,
    price = price
)

fun HookahInfoEntity.toDomain(): HookahInfo = HookahInfo(
    id = id,
    name = name,
    description = description,
    type = type,
    price = price
)