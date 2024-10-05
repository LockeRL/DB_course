package com.qoollo.hookah_center.domain.repository.local

import com.qoollo.hookah_center.common.repository.local.ILocalOwnerRepository
import com.qoollo.hookah_center.datasource.local.db.dao.OwnerDao
import com.qoollo.hookah_center.datasource.local.db.mapper.toDomain
import com.qoollo.hookah_center.datasource.local.db.mapper.toEntity
import com.qoollo.hookah_center.domain.model.Owner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalOwnerRepository(private val dao: OwnerDao) : ILocalOwnerRepository {
    override suspend fun insert(owner: Owner) {
        dao.deleteAll()
        dao.insertOwner(owner.toEntity())
    }

    override fun read(): Flow<Owner?> = dao.getOwner().map { owner -> owner?.toDomain() }
}