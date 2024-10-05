package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.common.repository.remote.IRemoteBarsRepository
import com.qoollo.hookah_center.common.repository.remote.IRemoteUsersRepository
import com.qoollo.hookah_center.domain.repository.remote.RemoteBarsRepository
import com.qoollo.hookah_center.domain.repository.remote.RemoteUsersRepository
import org.koin.dsl.module

val remoteRepositoryModule = module {
    factory<IRemoteUsersRepository> { RemoteUsersRepository(get()) }
    factory<IRemoteBarsRepository> { RemoteBarsRepository(get()) }
}