package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IFoodDaoService
import com.qoollo.datasource.local.dao.BarsFoodDao
import com.qoollo.datasource.local.dao.FoodDao
import com.qoollo.datasource.local.entity.db.BarFoodEntity
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.BarFood
import com.qoollo.domain.model.db.Food
import com.qoollo.domain.model.info.FoodInfo
import java.util.*

class FoodDaoService(
    private val foodDao: FoodDao,
    private val barsFoodDao: BarsFoodDao
) : IFoodDaoService {

    override suspend fun insert(model: Food): UUID = dbQuery { foodDao.insert(model.toEntity()) }

    override suspend fun insert(barId: UUID, model: FoodInfo): UUID =
        dbQuery {
            val foodId = foodDao.insert(model.toEntity())
            barsFoodDao.insert(
                BarFoodEntity(
                    barId = barId,
                    foodId = foodId,
                    price = model.price
                )
            )
            foodId
        }

    override suspend fun insertAll(modelList: List<Food>): List<UUID> = dbQuery {
        foodDao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun insertAll(barId: UUID, modelList: List<FoodInfo>): List<UUID> =
        dbQuery {
            val foodIds = foodDao.insertAll(modelList.map { foodInfo -> foodInfo.toEntity() })
            val barFoodEntities: List<BarFoodEntity> = getBarFoodEntities(barId, foodIds, modelList)
            barsFoodDao.insertAll(barFoodEntities)
            foodIds
        }

    override suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<FoodInfo>): List<UUID> =
        dbQuery {
            val foodIds = foodDao.insertAll(modelList.map { drinkInfo -> drinkInfo.toEntity() })
            val barFoodEntities: MutableList<BarFoodEntity> = mutableListOf()
            barIds.forEach { uuid ->
                barFoodEntities.addAll(getBarFoodEntities(uuid, foodIds, modelList))
            }
            barsFoodDao.insertAll(barFoodEntities)
            foodIds
        }

    override suspend fun read(id: UUID): Food? = dbQuery { foodDao.read(id)?.toDomain() }

    override suspend fun readAll(): List<Food> = dbQuery {
        foodDao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Food) = dbQuery { foodDao.update(id, model.toEntity()) }

    override suspend fun update(food: FoodInfo) = dbQuery {
        foodDao.update(food.id, food.toEntity())
        barsFoodDao.updatePrice(food.id, food.price)
    }

    override suspend fun updateAll(modelMap: Map<UUID, Food>) = dbQuery {
        foodDao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { foodDao.delete(id) }

    override suspend fun delete(barId: UUID, foodId: UUID) = dbQuery { barsFoodDao.delete(barId, foodId) }

    override suspend fun delete(barsId: List<UUID>, foodId: UUID) = dbQuery { barsFoodDao.delete(barsId, foodId) }

    override suspend fun deleteAll() = dbQuery { foodDao.deleteAll() }

    private fun getBarFoodEntities(
        barId: UUID,
        foodIds: List<UUID>,
        modelList: List<FoodInfo>
    ): List<BarFoodEntity> =
        foodIds.mapIndexed { index, uuid ->
            BarFoodEntity(
                barId = barId,
                foodId = uuid,
                price = modelList[index].price
            )
        }
}