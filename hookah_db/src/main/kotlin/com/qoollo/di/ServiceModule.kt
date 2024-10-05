package com.qoollo.di

import com.qoollo.data.datasource.local.service.*
import com.qoollo.datasource.local.service.*
import org.koin.dsl.module

val serviceModule = module {
    factory<IAdminsDaoService> { AdminsDaoService(get(), get()) }
    factory<IBarsDaoService> { BarsDaoService(get()) }
    factory<ICommentsDaoService> { CommentsDaoService(get()) }
    factory<IComplexDaoService> { ComplexDaoService(get()) }
    factory<IDrinksDaoService> { DrinksDaoService(get(), get()) }
    factory<IFoodDaoService> { FoodDaoService(get(), get()) }
    factory<IHookahsDaoService> { HookahsDaoService(get(), get()) }
    factory<IOrganizationsDaoService> { OrganizationsDaoService(get()) }
    factory<IUsersDaoService> { UsersDaoService(get()) }
}