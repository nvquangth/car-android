package com.bt.car.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.liveData
import com.bt.base.ui.BaseViewModel
import com.bt.car.anotation.IoDispatcher
import com.bt.car.data.repository.CarRepository
import kotlinx.coroutines.CoroutineDispatcher

class HomeViewModel @ViewModelInject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: CarRepository
) : BaseViewModel() {

    val makers = liveData(dispatcher) {
        showLoading()
        emit(repository.getAllMakerItem())
        hideLoading()
    }
}
