package com.qoollo.hookah_center.domain.mapper

import com.qoollo.hookah_center.domain.model.Owner
import com.qoollo.hookah_center.domain.model.User
import com.qoollo.hookah_center.domain.model.UserInfo
import java.util.UUID

fun UserInfo.toOwner(): Owner = Owner(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)

fun User.toOwner(id: UUID): Owner = Owner(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)