package com.qoollo.hookah_center.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qoollo.hookah_center.datasource.local.db.dao.BarsDao
import com.qoollo.hookah_center.datasource.local.db.dao.DrinksDao
import com.qoollo.hookah_center.datasource.local.db.dao.FoodDao
import com.qoollo.hookah_center.datasource.local.db.dao.HookahsDao
import com.qoollo.hookah_center.datasource.local.db.dao.OwnerDao
import com.qoollo.hookah_center.datasource.local.db.dao.UserDao
import com.qoollo.hookah_center.datasource.local.db.entity.BarEntity
import com.qoollo.hookah_center.datasource.local.db.entity.DrinkEntity
import com.qoollo.hookah_center.datasource.local.db.entity.FoodEntity
import com.qoollo.hookah_center.datasource.local.db.entity.HookahEntity
import com.qoollo.hookah_center.datasource.local.db.entity.OwnerEntity
import com.qoollo.hookah_center.datasource.local.db.entity.UserEntity


@Database(
    entities = [
        UserEntity::class,
        OwnerEntity::class,
        BarEntity::class,
        DrinkEntity::class,
        FoodEntity::class,
        HookahEntity::class
    ],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun ownerDao(): OwnerDao

    abstract fun barsDao(): BarsDao

    abstract fun foodDao(): FoodDao

    abstract fun drinksDao(): DrinksDao

    abstract fun hookahsDao(): HookahsDao

    companion object {
        const val DB_NAME = "local"
    }

}