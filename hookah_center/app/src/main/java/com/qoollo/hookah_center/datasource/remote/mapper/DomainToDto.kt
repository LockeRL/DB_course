package com.qoollo.hookah_center.datasource.remote.mapper

import com.qoollo.hookah_center.datasource.remote.model.UserDto
import com.qoollo.hookah_center.domain.model.User

fun User.toDto(): UserDto = UserDto(
    login = login,
    password = password,
    firstName = firstName,
    secondName = secondName
)