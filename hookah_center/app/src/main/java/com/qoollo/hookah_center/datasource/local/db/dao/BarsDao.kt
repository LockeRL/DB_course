package com.qoollo.hookah_center.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qoollo.hookah_center.datasource.local.db.entity.BarEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface BarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBars(bars: List<BarEntity>)

    @Query("select * from bars")
    fun readBars(): Flow<List<BarEntity>>

    @Query("select * from bars where id = (:id)")
    fun read(id: UUID): Flow<BarEntity?>

    @Query("delete from bars")
    suspend fun deleteAll()
}