package com.qoollo.hookah_center.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qoollo.hookah_center.datasource.local.db.entity.FoodEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: List<FoodEntity>)

    @Query("select * from food")
    fun readFood(): Flow<List<FoodEntity>>

    @Query("select * from food where id = (:id)")
    fun read(id: UUID): Flow<FoodEntity?>

    @Query("delete from food")
    suspend fun deleteAll()
}