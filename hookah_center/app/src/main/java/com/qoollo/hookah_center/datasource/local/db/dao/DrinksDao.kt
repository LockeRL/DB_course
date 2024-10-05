package com.qoollo.hookah_center.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qoollo.hookah_center.datasource.local.db.entity.DrinkEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface DrinksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinks(drinks: List<DrinkEntity>)

    @Query("select * from drinks")
    fun readDrinks(): Flow<List<DrinkEntity>>

    @Query("select * from drinks where id = (:id)")
    fun read(id: UUID): Flow<DrinkEntity?>

    @Query("delete from drinks")
    suspend fun deleteAll()
}