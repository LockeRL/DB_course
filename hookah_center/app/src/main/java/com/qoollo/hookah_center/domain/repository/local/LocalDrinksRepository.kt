package com.qoollo.hookah_center.domain.repository.local

import com.qoollo.hookah_center.common.repository.local.ILocalDrinksRepository
import com.qoollo.hookah_center.datasource.local.db.dao.DrinksDao
import com.qoollo.hookah_center.datasource.local.db.mapper.toDomain
import com.qoollo.hookah_center.datasource.local.db.mapper.toEntity
import com.qoollo.hookah_center.domain.model.Drink
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class LocalDrinksRepository(private val dao: DrinksDao) : ILocalDrinksRepository {
    override suspend fun insert(drinks: List<Drink>) {
        dao.deleteAll()
        dao.insertDrinks(
            drinks.map { drink ->
                drink.toEntity()
            }
        )
    }

    override fun read(): Flow<List<Drink>> =
        dao.readDrinks().map { list ->
            list.map { drink ->
                drink.toDomain()
            }
        }

    override fun read(id: UUID): Flow<Drink?> =
        dao.read(id).map { drink ->
            drink?.toDomain()
        }
}