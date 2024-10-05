package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IHookahsDaoService
import com.qoollo.datasource.local.dao.BarsHookahsDao
import com.qoollo.datasource.local.dao.HookahsDao
import com.qoollo.datasource.local.entity.db.BarFoodEntity
import com.qoollo.datasource.local.entity.db.BarHookahEntity
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.BarHookah
import com.qoollo.domain.model.db.Hookah
import com.qoollo.domain.model.info.HookahInfo
import java.util.*

class HookahsDaoService(
    private val hookahsDao: HookahsDao,
    private val barsHookahsDao: BarsHookahsDao
) : IHookahsDaoService {

    override suspend fun insert(model: Hookah): UUID = dbQuery { hookahsDao.insert(model.toEntity()) }

    override suspend fun insert(barId: UUID, model: HookahInfo): UUID =
        dbQuery {
            val hookahId = hookahsDao.insert(model.toEntity())
            barsHookahsDao.insert(
                BarHookahEntity(
                    barId = barId,
                    hookahId = hookahId,
                    price = model.price
                )
            )
            hookahId
        }

    override suspend fun insertAll(modelList: List<Hookah>): List<UUID> = dbQuery {
        hookahsDao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun insertAll(barId: UUID, modelList: List<HookahInfo>): List<UUID> =
        dbQuery {
            val hookahIds = hookahsDao.insertAll(modelList.map { hookahInfo -> hookahInfo.toEntity() })
            val barHookahEntities: List<BarHookahEntity> = getBarHookahEntities(barId, hookahIds, modelList)
            barsHookahsDao.insertAll(barHookahEntities)
            hookahIds
        }

    override suspend fun insertAllInBars(barIds: List<UUID>, modelList: List<HookahInfo>): List<UUID> =
        dbQuery {
            val hookahIds = hookahsDao.insertAll(modelList.map { hookahInfo -> hookahInfo.toEntity() })
            val barHookahEntities: MutableList<BarHookahEntity> = mutableListOf()
            barIds.forEach { uuid ->
                barHookahEntities.addAll(getBarHookahEntities(uuid, hookahIds, modelList))
            }
            barsHookahsDao.insertAll(barHookahEntities)
            hookahIds
        }

    override suspend fun read(id: UUID): Hookah? = dbQuery { hookahsDao.read(id)?.toDomain() }

    override suspend fun readAll(): List<Hookah> = dbQuery {
        hookahsDao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Hookah) = dbQuery { hookahsDao.update(id, model.toEntity()) }

    override suspend fun update(hookah: HookahInfo) = dbQuery {
        hookahsDao.update(hookah.id, hookah.toEntity())
        barsHookahsDao.updatePrice(hookah.id, hookah.price)
    }

    override suspend fun updateAll(modelMap: Map<UUID, Hookah>) = dbQuery {
        hookahsDao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { hookahsDao.delete(id) }

    override suspend fun delete(barId: UUID, hookahId: UUID) = dbQuery { barsHookahsDao.delete(barId, hookahId) }

    override suspend fun delete(barsId: List<UUID>, hookahId: UUID) =
        dbQuery { barsHookahsDao.delete(barsId, hookahId) }

    override suspend fun deleteAll() = dbQuery { hookahsDao.deleteAll() }

    private fun getBarHookahEntities(
        barId: UUID,
        hookahIds: List<UUID>,
        modelList: List<HookahInfo>
    ): List<BarHookahEntity> =
        hookahIds.mapIndexed { index, uuid ->
            BarHookah(
                barId = barId,
                hookahId = uuid,
                price = modelList[index].price
            ).toEntity()
        }
}