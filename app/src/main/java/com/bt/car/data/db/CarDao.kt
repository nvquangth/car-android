package com.bt.car.data.db

import androidx.room.Dao
import androidx.room.Query
import com.bt.car.data.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {

    @Query("SELECT * FROM car")
    fun getCars(): Flow<List<Car>>
}
