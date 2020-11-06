package com.bt.car.ui.cardetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bt.base.ui.BaseViewModel
import com.bt.car.anotation.IoDispatcher
import com.bt.car.data.model.InfoItem
import com.bt.car.data.repository.CarRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

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

    private val _info = MutableLiveData<List<InfoItem>>()
    val info: LiveData<List<InfoItem>>
        get() = _info

    fun getInfo(model: String) {
        viewModelScope.launch(dispatcher) {
            val car = repository.getCarByModel(model)
            val fields = car.javaClass.declaredFields
            val infors = arrayListOf<InfoItem>()

            fields.forEach {
                it.isAccessible = true
                val title = it.name
                val value = it.get(car)?.toString()
                infors.add(InfoItem(title, value))
            }

            _info.postValue(infors)
        }
    }
}
