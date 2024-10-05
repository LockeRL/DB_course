package com.qoollo.data.datasource.local.service


import com.qoollo.domain.model.db.Bar
import com.qoollo.domain.model.db.Org
import com.qoollo.domain.model.info.*

import java.util.*

interface IComplexDaoService {
    suspend fun getBarsWithScore(): List<BarInfo>

    suspend fun getBarWithFood(barId: UUID): List<FoodInfo>

    suspend fun getBarWithHookahs(barId: UUID): List<HookahInfo>

    suspend fun getBarWithDrinks(barId: UUID): List<DrinkInfo>

    suspend fun getUserInfo(userId: UUID): UserInfo?

    suspend fun getBarComments(barId: UUID): List<CommentInfo>

    suspend fun getAdministeredBars(adminId: UUID): List<BarInfo>
}