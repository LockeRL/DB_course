package com.qoollo.di

import com.qoollo.data.repository.*
import com.qoollo.domain.repository.*
import org.koin.dsl.module


val repositoryModule = module {
    factory<IAdminsRepository> { AdminsRepository(get(), get()) }
    factory<IBarsRepository> { BarsRepository(get(), get()) }
    factory<ICommentsRepository> { CommentsRepository(get()) }
    factory<IDrinksRepository> { DrinksRepository(get()) }
    factory<IFoodRepository> { FoodRepository(get()) }
    factory<IHookahsRepository> { HookahsRepository(get()) }
    factory<IOrganizationsRepository> { OrganizationsRepository(get()) }
    factory<IUsersRepository> { UsersRepository(get(), get()) }
}