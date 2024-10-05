package com.qoollo.hookah_center

import android.app.Application
import com.qoollo.hookah_center.di.daoModule
import com.qoollo.hookah_center.di.databaseModule
import com.qoollo.hookah_center.di.localRepositoryModule
import com.qoollo.hookah_center.di.okHttpClientModule
import com.qoollo.hookah_center.di.remoteRepositoryModule
import com.qoollo.hookah_center.di.retrofitModule
import com.qoollo.hookah_center.di.serviceModule
import com.qoollo.hookah_center.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HookahApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                okHttpClientModule,
                retrofitModule,
                serviceModule,
                remoteRepositoryModule,
                viewModelModule,
                databaseModule,
                daoModule,
                localRepositoryModule
            )
        }
    }
}