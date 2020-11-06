package com.bt.car.data.repository

import com.bt.car.data.model.Car
import com.bt.car.data.model.MakerItem
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    fun getCars(): Flow<List<Car>>

    suspend fun getAllMaker(): List<String>

    fun getTotalMaker(): Int

    suspend fun getModelByMaker(maker: String): List<String>

    suspend fun getCarByModel(model: String): Car

    fun getTotalModelByMaker(maker: String): Int

    fun findMaker(q: String): Flow<List<String>>

    fun findModel(q: String): Flow<List<String>>

    fun find(q: String): Flow<List<Car>>

    suspend fun getAllMakerItem(): List<MakerItem>
}
