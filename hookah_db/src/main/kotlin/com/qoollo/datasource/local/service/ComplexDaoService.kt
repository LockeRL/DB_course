package com.qoollo.datasource.local.service

import com.qoollo.data.datasource.local.service.IComplexDaoService
import com.qoollo.datasource.local.dao.BarsDao
import com.qoollo.datasource.local.dao.ComplexDao
import com.qoollo.datasource.local.dao.OrganizationsDao
import com.qoollo.datasource.local.mapper.toDomain
import com.qoollo.datasource.local.mapper.toEntity
import com.qoollo.datasource.local.util.dbQuery
import com.qoollo.domain.model.db.Bar
import com.qoollo.domain.model.db.Org
import com.qoollo.domain.model.info.*
import java.util.*

class ComplexDaoService(
    private val complexDao: ComplexDao
) : IComplexDaoService {

    override suspend fun getBarsWithScore(): List<BarInfo> = dbQuery {
        complexDao.getBarsWithScore().map { barInfoEntity ->
            barInfoEntity.toDomain()
        }
    }

    override suspend fun getBarWithFood(barId: UUID): List<FoodInfo> = dbQuery {
        complexDao.getBarWithFood(barId).map { foodInfoEntity ->
            foodInfoEntity.toDomain()
        }
    }

    override suspend fun getBarWithHookahs(barId: UUID): List<HookahInfo> = dbQuery {
        complexDao.getBarWithHookahs(barId).map { hookahInfoEntity ->
            hookahInfoEntity.toDomain()
        }
    }

    override suspend fun getBarWithDrinks(barId: UUID): List<DrinkInfo> = dbQuery {
        complexDao.getBarWithDrinks(barId).map { drinkInfoEntity ->
            drinkInfoEntity.toDomain()
        }
    }

    override suspend fun getUserInfo(userId: UUID): UserInfo? = dbQuery { complexDao.getUserInfo(userId)?.toDomain() }

    override suspend fun getBarComments(barId: UUID): List<CommentInfo> = dbQuery {
        complexDao.getBarComments(barId).map { commentInfoEntity ->
            commentInfoEntity.toDomain()
        }
    }

    override suspend fun getAdministeredBars(adminId: UUID): List<BarInfo> = dbQuery {
        complexDao.getAdministeredBars(adminId).map { barInfoEntity ->
            barInfoEntity.toDomain()
        }
    }
}