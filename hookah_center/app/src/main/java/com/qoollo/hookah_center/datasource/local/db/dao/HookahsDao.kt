package com.qoollo.hookah_center.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qoollo.hookah_center.datasource.local.db.entity.HookahEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface HookahsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHookahs(hookahs: List<HookahEntity>)

    @Query("select * from hookahs")
    fun readHookahs(): Flow<List<HookahEntity>>

    @Query("select * from hookahs where id = (:id)")
    fun read(id: UUID): Flow<HookahEntity?>

    @Query("delete from hookahs")
    suspend fun deleteAll()
}