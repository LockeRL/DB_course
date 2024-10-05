package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.common.NetworkDependencies
import com.qoollo.hookah_center.datasource.remote.service.IBarsService
import com.qoollo.hookah_center.datasource.remote.service.IUserService
import org.koin.dsl.module

val serviceModule = module {
    factory<IUserService> { NetworkDependencies.provideUsersService(get()) }
    factory<IBarsService> { NetworkDependencies.provideBarsService(get()) }
}