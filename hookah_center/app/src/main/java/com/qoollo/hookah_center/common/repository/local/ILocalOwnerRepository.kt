package com.qoollo.hookah_center.common.repository.local

import com.qoollo.hookah_center.domain.model.Owner
import kotlinx.coroutines.flow.Flow

interface ILocalOwnerRepository {
    suspend fun insert(owner: Owner)
    fun read(): Flow<Owner?>
}