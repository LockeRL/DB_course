package com.qoollo.hookah_center.common

import com.qoollo.hookah_center.BuildConfig
import com.qoollo.hookah_center.datasource.remote.api.BarsApi
import com.qoollo.hookah_center.datasource.remote.api.UsersApi
import com.qoollo.hookah_center.datasource.remote.service.BarsService
import com.qoollo.hookah_center.datasource.remote.service.UserService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkDependencies {
    fun provideOkHttp(): OkHttpClient = OkHttpClient()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideUsersService(retrofit: Retrofit): UserService =
        UserService(retrofit.create(UsersApi::class.java))

    fun provideBarsService(retrofit: Retrofit): BarsService =
        BarsService(retrofit.create(BarsApi::class.java))
}