package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.common.LocalProvider
import com.qoollo.hookah_center.datasource.local.db.LocalDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<LocalDatabase> { LocalProvider.getInstance(get()) }
}