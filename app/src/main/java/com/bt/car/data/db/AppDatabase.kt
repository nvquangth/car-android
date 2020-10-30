package com.bt.car.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bt.car.data.model.Car

@Database(entities = [Car::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao
}
