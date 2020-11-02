package com.bt.car.data.repository

import com.bt.car.data.db.CarDao
import com.bt.car.data.model.Car
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val dao: CarDao
) : CarRepository {

    override fun getCars(): Flow<List<Car>> = dao.getAllCar()

    override fun getAllMaker(): Flow<List<String>> = dao.getAllMaker()

    override fun getTotalMaker(): Int = dao.getTotalMaker()

    override fun getModelByMaker(maker: String): Flow<List<String>> = dao.getModelByMaker(maker)

    override fun getTotalModelByMaker(maker: String): Int = dao.getTotalModelByMaker(maker)

    override fun findMaker(q: String): Flow<List<String>> = dao.findMaker(q)

    override fun findModel(q: String): Flow<List<String>> = dao.findModel(q)

    override fun find(q: String): Flow<List<Car>> = dao.find(q)
}
