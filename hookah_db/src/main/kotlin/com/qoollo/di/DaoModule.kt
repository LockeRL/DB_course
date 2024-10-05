package com.qoollo.di

import com.qoollo.datasource.local.dao.*
import org.koin.dsl.module


val daoModule = module {
    factory<AdminsBarsDao> { object : AdminsBarsDao() {} }
    factory<AdminsDao> { object : AdminsDao() {} }
    factory<BarsDao> { object : BarsDao() {} }
    factory<BarsDrinksDao> { object : BarsDrinksDao() {} }
    factory<BarsHookahsDao> { object : BarsHookahsDao() {} }
    factory<BarsFoodDao> { object : BarsFoodDao() {} }
    factory<CommentsDao> { object : CommentsDao() {} }
    factory<ComplexDao> { object : ComplexDao() {} }
    factory<DrinksDao> { object : DrinksDao() {} }
    factory<FoodDao> { object : FoodDao() {} }
    factory<HookahsDao> { object : HookahsDao() {} }
    factory<OrganizationsDao> { object : OrganizationsDao() {} }
    factory<UsersDao> { object : UsersDao() {} }
}