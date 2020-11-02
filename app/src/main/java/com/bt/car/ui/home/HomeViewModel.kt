package com.bt.car.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.bt.base.ui.BaseViewModel
import com.bt.car.anotation.DefaultDispatcher
import com.bt.car.data.model.Car
import com.bt.car.data.repository.CarRepository
import kotlinx.coroutines.CoroutineDispatcher

class HomeViewModel @ViewModelInject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: CarRepository
) : BaseViewModel() {

    val cars = liveData<List<Car>>(dispatcher) {
        emitSource(repository.getCars().asLiveData())
    }
}
