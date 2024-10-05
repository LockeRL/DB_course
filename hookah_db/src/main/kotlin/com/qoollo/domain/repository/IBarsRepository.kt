package com.qoollo.domain.repository

import com.qoollo.domain.model.db.Bar
import com.qoollo.domain.model.db.Org
import com.qoollo.domain.model.info.*
import java.util.*

interface IBarsRepository {
    suspend fun insertBar(model: Bar): UUID
    suspend fun insertAllBars(modelList: List<Bar>): List<UUID>
    suspend fun updateBar(id: UUID, model: Bar)
    suspend fun deleteBar(id: UUID)
    suspend fun getBarsWithScore(): List<BarInfo>
    suspend fun getBarWithFood(barId: UUID): List<FoodInfo>
    suspend fun getBarWithHookahs(barId: UUID): List<HookahInfo>
    suspend fun getBarWithDrinks(barId: UUID): List<DrinkInfo>
    suspend fun getBarComments(barId: UUID): List<CommentInfo>
}