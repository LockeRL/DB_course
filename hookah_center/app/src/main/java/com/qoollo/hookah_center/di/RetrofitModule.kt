package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.common.NetworkDependencies
import org.koin.dsl.module
import retrofit2.Retrofit

val retrofitModule = module {
    factory<Retrofit> { NetworkDependencies.provideRetrofit(get()) }
}