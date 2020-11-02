package com.bt.car.data.repository

import com.bt.car.data.db.CarDao
import com.bt.car.data.model.Car
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val dao: CarDao
): CarRepository {

    override fun getCars(): Flow<List<Car>> = dao.getCars()
}