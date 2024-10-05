package com.qoollo.hookah_center.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qoollo.hookah_center.datasource.local.db.entity.OwnerEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface OwnerDao {
    @Query("select * from owner")
    fun getOwner(): Flow<OwnerEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: OwnerEntity)

    @Query("delete from owner")
    suspend fun deleteAll()
}