package com.qoollo.hookah_center.common.repository.local

import com.qoollo.hookah_center.domain.model.User
import com.qoollo.hookah_center.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface ILocalUsersRepository {
    suspend fun insertUser(user: UserInfo)
    fun getUser(id: UUID): Flow<UserInfo>
}