package com.qoollo.data.repository

import com.qoollo.data.datasource.local.service.*
import com.qoollo.datasource.local.dao.ComplexDao
import com.qoollo.domain.model.db.*
import com.qoollo.domain.model.info.*
import com.qoollo.domain.repository.IBarsRepository
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class BarsRepository(
    private val barsService: IBarsDaoService,
    private val complexDaoService: IComplexDaoService
) : IBarsRepository {
    override suspend fun insertBar(model: Bar): UUID = barsService.insert(model)

    override suspend fun insertAllBars(modelList: List<Bar>): List<UUID> = barsService.insertAll(modelList)

    override suspend fun updateBar(id: UUID, model: Bar) = barsService.update(id, model)

    override suspend fun deleteBar(id: UUID) = barsService.delete(id)

    override suspend fun getBarsWithScore(): List<BarInfo> = complexDaoService.getBarsWithScore()

    override suspend fun getBarWithFood(barId: UUID): List<FoodInfo> = complexDaoService.getBarWithFood(barId)

    override suspend fun getBarWithHookahs(barId: UUID): List<HookahInfo> = complexDaoService.getBarWithHookahs(barId)

    override suspend fun getBarWithDrinks(barId: UUID): List<DrinkInfo> = complexDaoService.getBarWithDrinks(barId)

    override suspend fun getBarComments(barId: UUID): List<CommentInfo> = complexDaoService.getBarComments(barId)
}