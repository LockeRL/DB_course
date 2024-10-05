package com.qoollo.hookah_center.presentation.mapper

import com.qoollo.hookah_center.domain.model.UserInfo
import com.qoollo.hookah_center.presentation.model.UserInfoViewData


fun UserInfoViewData.toDomain(): UserInfo = UserInfo(
    id = id,
    login = login,
    firstName = firstName,
    secondName = secondName
)