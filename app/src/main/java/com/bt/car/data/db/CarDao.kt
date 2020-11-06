package com.bt.car.data.db

import androidx.room.Dao
import androidx.room.Query
import com.bt.car.data.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {

    @Query("SELECT * FROM car")
    fun getAllCar(): Flow<List<Car>>

    @Query("SELECT DISTINCT Make FROM car")
    suspend fun getAllMaker(): List<String>

    @Query("SELECT COUNT(DISTINCT Make) FROM car")
    fun getTotalMaker(): Int

    @Query("SELECT DISTINCT Model FROM car WHERE Make = :maker")
    suspend fun getModelByMaker(maker: String): List<String>

    @Query("SELECT * FROM car WHERE Model = :model")
    suspend fun getCarByModel(model: String): List<Car>

    @Query("SELECT COUNT(DISTINCT Model) FROM car WHERE Make = :maker")
    fun getTotalModelByMaker(maker: String): Int

    @Query("SELECT DISTINCT Make FROM car WHERE Make LIKE '%' || :q || '%'")
    fun findMaker(q: String): Flow<List<String>>

    @Query("SELECT DISTINCT Model FROM car WHERE Model LIKE '%' || :q || '%'")
    fun findModel(q: String): Flow<List<String>>

    @Query("SELECT * FROM car WHERE Make LIKE '%' || :q || '%' OR Model LIKE '%' || :q || '%'")
    fun find(q: String): Flow<List<Car>>
}
