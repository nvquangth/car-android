package com.bt.car.data.repository

import com.bt.car.data.model.Car
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    fun getCars(): Flow<List<Car>>
}