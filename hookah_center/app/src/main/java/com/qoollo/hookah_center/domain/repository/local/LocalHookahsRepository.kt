package com.qoollo.hookah_center.domain.repository.local

import com.qoollo.hookah_center.common.repository.local.ILocalHookahsRepository
import com.qoollo.hookah_center.datasource.local.db.dao.HookahsDao
import com.qoollo.hookah_center.datasource.local.db.mapper.toDomain
import com.qoollo.hookah_center.datasource.local.db.mapper.toEntity
import com.qoollo.hookah_center.domain.model.Hookah
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class LocalHookahsRepository(private val dao: HookahsDao) : ILocalHookahsRepository {
    override suspend fun insert(hookahs: List<Hookah>) {
        dao.deleteAll()
        dao.insertHookahs(
            hookahs.map { hookah ->
                hookah.toEntity()
            }
        )
    }

    override fun read(): Flow<List<Hookah>> =
        dao.readHookahs().map { list ->
            list.map { hookah ->
                hookah.toDomain()
            }
        }

    override fun read(id: UUID): Flow<Hookah?> =
        dao.read(id).map { hookah ->
            hookah?.toDomain()
        }
}