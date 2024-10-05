package com.qoollo.hookah_center.common

import android.content.Context
import androidx.room.Room
import com.qoollo.hookah_center.datasource.local.db.LocalDatabase

object LocalProvider {

    private var db: LocalDatabase? = null

    fun getInstance(context: Context): LocalDatabase = db ?: run {
        val instance = provideDb(context)
        db = instance
        instance
    }

    private fun provideDb(appContext: Context): LocalDatabase =
        Room
            .databaseBuilder(
                appContext,
                LocalDatabase::class.java,
                LocalDatabase.DB_NAME
            )
            .build()
}