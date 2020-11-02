package com.bt.car.di

import android.content.Context
import androidx.room.Room
import com.bt.car.data.db.AppDatabase
import com.bt.car.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun createDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME)
            .createFromAsset("db/car.db")
            .build()

    @Singleton
    @Provides
    fun provideCategoryDao(database: AppDatabase) = database.carDao()
}
