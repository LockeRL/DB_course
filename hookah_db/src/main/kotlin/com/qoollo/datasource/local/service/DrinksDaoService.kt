package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IDrinksDaoService
import com.qoollo.datasource.local.dao.BarsDrinksDao
import com.qoollo.datasource.local.dao.DrinksDao
import com.qoollo.datasource.local.entity.db.BarDrinkEntity
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.BarDrink
import com.qoollo.domain.model.db.Drink
import com.qoollo.domain.model.info.DrinkInfo
import java.util.*

class DrinksDaoService(
    private val drinksDao: DrinksDao,
    private val barsDrinksDao: BarsDrinksDao
) : IDrinksDaoService {

    override suspend fun insert(model: Drink): UUID = dbQuery { drinksDao.insert(model.toEntity()) }

    override suspend fun insert(barId: UUID, model: DrinkInfo): UUID =
        dbQuery {
            val drinkId = drinksDao.insert(model.toEntity())
            barsDrinksDao.insert(
                BarDrinkEntity(
                    barId = barId,
                    drinkId = drinkId,
                    price = model.price
                )
            )
            drinkId
        }

    override suspend fun insertAll(modelList: List<Drink>): List<UUID> = dbQuery {
        drinksDao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun insertAll(barId: UUID, modelList: List<DrinkInfo>): List<UUID> =
        dbQuery {
            val drinkIds = drinksDao.insertAll(modelList.map { drinkInfo -> drinkInfo.toEntity() })
            val barDrinkEntities: List<BarDrinkEntity> = getBarDrinkEntities(barId, drinkIds, modelList)
            barsDrinksDao.insertAll(barDrinkEntities)
            drinkIds
        }

    override suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<DrinkInfo>): List<UUID> =
        dbQuery {
            val drinkIds = drinksDao.insertAll(modelList.map { drinkInfo -> drinkInfo.toEntity() })
            val barDrinkEntities: MutableList<BarDrinkEntity> = mutableListOf()
            barIds.forEach { uuid ->
                barDrinkEntities.addAll(getBarDrinkEntities(uuid, drinkIds, modelList))
            }
            barsDrinksDao.insertAll(barDrinkEntities)
            drinkIds
        }

    override suspend fun read(id: UUID): Drink? = dbQuery { drinksDao.read(id)?.toDomain() }

    override suspend fun readAll(): List<Drink> = dbQuery {
        drinksDao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Drink) = dbQuery { drinksDao.update(id, model.toEntity()) }

    override suspend fun update(drink: DrinkInfo) = dbQuery {
        drinksDao.update(drink.id, drink.toEntity())
        barsDrinksDao.updatePrice(drink.id, drink.price)
    }

    override suspend fun updateAll(modelMap: Map<UUID, Drink>) = dbQuery {
        drinksDao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { drinksDao.delete(id) }

    override suspend fun delete(barId: UUID, drinkId: UUID) = dbQuery { barsDrinksDao.delete(barId, drinkId) }

    override suspend fun delete(barsId: List<UUID>, drinkId: UUID) = dbQuery { barsDrinksDao.delete(barsId, drinkId) }

    override suspend fun deleteAll() = dbQuery { drinksDao.deleteAll() }

    private fun getBarDrinkEntities(
        barId: UUID,
        drinkIds: List<UUID>,
        modelList: List<DrinkInfo>
    ): List<BarDrinkEntity> =
        drinkIds.mapIndexed { index, uuid ->
            BarDrinkEntity(
                barId = barId,
                drinkId = uuid,
                price = modelList[index].price
            )
        }
}