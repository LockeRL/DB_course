package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.datasource.local.db.LocalDatabase
import com.qoollo.hookah_center.datasource.local.db.dao.BarsDao
import com.qoollo.hookah_center.datasource.local.db.dao.DrinksDao
import com.qoollo.hookah_center.datasource.local.db.dao.FoodDao
import com.qoollo.hookah_center.datasource.local.db.dao.HookahsDao
import com.qoollo.hookah_center.datasource.local.db.dao.OwnerDao
import com.qoollo.hookah_center.datasource.local.db.dao.UserDao
import org.koin.dsl.module

val daoModule = module {
    factory<UserDao> { get<LocalDatabase>().userDao() }
    factory<OwnerDao> { get<LocalDatabase>().ownerDao() }
    factory<BarsDao> { get<LocalDatabase>().barsDao() }
    factory<DrinksDao> { get<LocalDatabase>().drinksDao() }
    factory<FoodDao> { get<LocalDatabase>().foodDao() }
    factory<HookahsDao> { get<LocalDatabase>().hookahsDao() }
}