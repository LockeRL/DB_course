package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.common.repository.local.ILocalBarsRepository
import com.qoollo.hookah_center.common.repository.local.ILocalDrinksRepository
import com.qoollo.hookah_center.common.repository.local.ILocalFoodRepository
import com.qoollo.hookah_center.common.repository.local.ILocalHookahsRepository
import com.qoollo.hookah_center.common.repository.local.ILocalOwnerRepository
import com.qoollo.hookah_center.common.repository.local.ILocalUsersRepository
import com.qoollo.hookah_center.domain.repository.local.LocalBarsRepository
import com.qoollo.hookah_center.domain.repository.local.LocalDrinksRepository
import com.qoollo.hookah_center.domain.repository.local.LocalFoodRepository
import com.qoollo.hookah_center.domain.repository.local.LocalHookahsRepository
import com.qoollo.hookah_center.domain.repository.local.LocalOwnerRepository
import com.qoollo.hookah_center.domain.repository.local.LocalUsersRepository
import org.koin.dsl.module

val localRepositoryModule = module {
    factory<ILocalUsersRepository> { LocalUsersRepository(get()) }
    factory<ILocalOwnerRepository> { LocalOwnerRepository(get()) }
    factory<ILocalHookahsRepository> { LocalHookahsRepository(get()) }
    factory<ILocalFoodRepository> { LocalFoodRepository(get()) }
    factory<ILocalBarsRepository> { LocalBarsRepository(get()) }
    factory<ILocalDrinksRepository> { LocalDrinksRepository(get()) }
}