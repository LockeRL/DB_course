package com.qoollo.hookah_center.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qoollo.hookah_center.datasource.local.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID


@Dao
interface UserDao {
    @Query("select * from user where id = (:id)")
    fun getUser(id: UUID): Flow<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)
}