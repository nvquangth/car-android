package com.bt.car.ui.cardetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bt.base.ui.BaseViewModel
import com.bt.car.anotation.IoDispatcher
import com.bt.car.data.repository.CarRepository
import kotlinx.coroutines.CoroutineDispatcher

class CarDetailViewModel @ViewModelInject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: CarRepository
) : BaseViewModel() {

    private val _maker = MutableLiveData<String>()

    val models = _maker.switchMap {
        liveData(dispatcher) {
            emit(repository.getModelByMaker(it))
        }
    }

    fun setMaker(maker: String) {
        _maker.value = maker
    }
}
