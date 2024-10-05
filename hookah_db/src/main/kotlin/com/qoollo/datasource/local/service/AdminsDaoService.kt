package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IAdminsDaoService
import com.qoollo.datasource.local.dao.AdminsBarsDao
import com.qoollo.datasource.local.dao.AdminsDao
import com.qoollo.datasource.local.dao.ComplexDao
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.currentDate
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.Admin
import com.qoollo.domain.model.db.AdminBar
import com.qoollo.domain.model.info.BarInfo
import java.util.*

class AdminsDaoService(
    private val adminsDao: AdminsDao,
    private val adminsBarsDao: AdminsBarsDao
) : IAdminsDaoService {

    override suspend fun insert(model: Admin): UUID = dbQuery { adminsDao.insert(model.toEntity()) }

    override suspend fun insert(barId: UUID, model: Admin): UUID =
        dbQuery {
            val adminId = adminsDao.insert(model.toEntity())
            adminsBarsDao.insert(
                AdminBar(
                    barId = barId,
                    adminId = adminId,
                    appointed = currentDate()
                ).toEntity()
            )
            adminId
        }

    override suspend fun insertAll(modelList: List<Admin>): List<UUID> = dbQuery {
        adminsDao.insertAll(
            modelList.map { adminBar ->
                adminBar.toEntity()
            }
        )
    }

    override suspend fun insertAll(barId: UUID, modelList: List<Admin>): List<UUID> = dbQuery {
        val adminIds = adminsDao.insertAll(modelList.map { admin -> admin.toEntity() })
        adminsBarsDao.insertAll(
            adminIds.map { id ->
                AdminBar(
                    barId = barId,
                    adminId = id,
                    appointed = currentDate()
                ).toEntity()
            }
        )
        adminIds
    }

    override suspend fun read(id: UUID): Admin? = dbQuery { adminsDao.read(id)?.toDomain() }

    override suspend fun readByUserId(userId: UUID): Admin? = dbQuery { adminsDao.readByUserId(userId)?.toDomain() }

    override suspend fun readAll(): List<Admin> = dbQuery {
        adminsDao.readAll().map { adminBarEntity ->
            adminBarEntity.toDomain()
        }
    }

    override suspend fun update(id: UUID, model: Admin) = dbQuery { adminsDao.update(id, model.toEntity()) }

    override suspend fun updateAll(modelMap: Map<UUID, Admin>) = dbQuery {
        adminsDao.updateAll(
            modelMap.mapValues { entry ->
                entry.value.toEntity()
            }
        )
    }

    override suspend fun delete(id: UUID) = dbQuery { adminsDao.delete(id) }

    override suspend fun delete(barId: UUID, adminId: UUID) = dbQuery { adminsBarsDao.delete(barId, adminId) }

    override suspend fun deleteAll() = dbQuery { adminsDao.deleteAll() }

    override suspend fun deleteAllInBar(barId: UUID) = dbQuery {
        val ids = adminsBarsDao.adminsInBar(barId)
        ids.forEach { id ->
            adminsDao.delete(id)
        }
    }
}