package com.qoollo.hookah_center.domain.repository.local

import com.qoollo.hookah_center.common.repository.local.ILocalFoodRepository
import com.qoollo.hookah_center.datasource.local.db.dao.FoodDao
import com.qoollo.hookah_center.datasource.local.db.mapper.toDomain
import com.qoollo.hookah_center.datasource.local.db.mapper.toEntity
import com.qoollo.hookah_center.domain.model.Food
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class LocalFoodRepository(private val dao: FoodDao) : ILocalFoodRepository {
    override suspend fun insert(food: List<Food>) {
        dao.deleteAll()
        dao.insertFood(
            food.map { foodItem ->
                foodItem.toEntity()
            }
        )
    }

    override fun read(): Flow<List<Food>> =
        dao.readFood().map { list ->
            list.map { food ->
                food.toDomain()
            }
        }

    override fun read(id: UUID): Flow<Food?> =
        dao.read(id).map { food ->
            food?.toDomain()
        }
}