package com.qoollo.hookah_center.domain.repository.local

import com.qoollo.hookah_center.common.repository.local.ILocalBarsRepository
import com.qoollo.hookah_center.datasource.local.db.dao.BarsDao
import com.qoollo.hookah_center.datasource.local.db.mapper.toDomain
import com.qoollo.hookah_center.datasource.local.db.mapper.toEntity
import com.qoollo.hookah_center.domain.model.Bar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class LocalBarsRepository(private val dao: BarsDao) : ILocalBarsRepository {
    override suspend fun insert(bars: List<Bar>) {
        dao.deleteAll()
        dao.insertBars(
            bars.map { bar ->
                bar.toEntity()
            }
        )
    }

    override fun read(): Flow<List<Bar>> =
        dao.readBars().map { list ->
            list.map { bar ->
                bar.toDomain()
            }
        }

    override fun read(id: UUID): Flow<Bar?> =
        dao.read(id).map { bar ->
            bar?.toDomain()
        }
}