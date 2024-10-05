package com.qoollo.hookah_center.datasource.remote.api

import com.qoollo.hookah_center.datasource.remote.model.UserDto
import com.qoollo.hookah_center.datasource.remote.model.UserInfoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

interface UsersApi {
    @GET("user/{id}")
    suspend fun getUserInfo(@Path("id") userId: UUID): Response<UserInfoDto>

    @GET("users")
    suspend fun getUserInfo(
        @Query("login") login: String,
        @Query("password") password: String
    ): Response<UserInfoDto>

    @POST("users")
    suspend fun signUp(@Body user: UserDto): Response<UUID>
}