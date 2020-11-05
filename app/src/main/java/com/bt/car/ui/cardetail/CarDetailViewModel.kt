package com.bt.car.ui.cardetail

import androidx.hilt.lifecycle.ViewModelInject
import com.bt.base.ui.BaseViewModel
import com.bt.car.anotation.IoDispatcher
import com.bt.car.data.repository.CarRepository
import kotlinx.coroutines.CoroutineDispatcher

class CarDetailViewModel @ViewModelInject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: CarRepository
) : BaseViewModel() {

}
