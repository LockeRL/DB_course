package com.qoollo.hookah_center.di

import com.qoollo.hookah_center.common.NetworkDependencies
import okhttp3.OkHttpClient
import org.koin.dsl.module


val okHttpClientModule = module {
    factory<OkHttpClient> { NetworkDependencies.provideOkHttp() }
}