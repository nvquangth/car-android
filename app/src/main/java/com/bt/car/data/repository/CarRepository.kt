package com.bt.car.data.repository

import com.bt.car.data.model.Car
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    fun getCars(): Flow<List<Car>>

    fun getAllMaker(): Flow<List<String>>

    fun getTotalMaker(): Int

    fun getModelByMaker(maker: String): Flow<List<String>>

    fun getTotalModelByMaker(maker: String): Int

    fun findMaker(q: String): Flow<List<String>>

    fun findModel(q: String): Flow<List<String>>

    fun find(q: String): Flow<List<Car>>
}
