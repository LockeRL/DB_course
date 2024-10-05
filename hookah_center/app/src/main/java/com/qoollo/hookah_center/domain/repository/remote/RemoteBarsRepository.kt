package com.qoollo.hookah_center.domain.repository.remote

import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.datasource.remote.mapper.toDomain
import com.qoollo.hookah_center.datasource.remote.service.IBarsService
import com.qoollo.hookah_center.domain.model.Bar
import com.qoollo.hookah_center.domain.model.Drink
import com.qoollo.hookah_center.domain.model.Food
import com.qoollo.hookah_center.domain.model.Hookah
import java.util.UUID

class RemoteBarsRepository(private val service: IBarsService) : IRemoteBarsRepository {
    override suspend fun getBars(): Result<List<Bar>> =
        service.getBars().map { list ->
            list.map { bar ->
                bar.toDomain()
            }
        }

    override suspend fun getFood(barId: UUID): Result<List<Food>> =
        service.getFood(barId).map { list ->
            list.map { food ->
                food.toDomain()
            }
        }

    override suspend fun getDrinks(barId: UUID): Result<List<Drink>> =
        service.getDrinks(barId).map { list ->
            list.map { drink ->
                drink.toDomain()
            }
        }

    override suspend fun getHookahs(barId: UUID): Result<List<Hookah>> =
        service.getHookahs(barId).map { list ->
            list.map { hookah ->
                hookah.toDomain()
            }
        }
}