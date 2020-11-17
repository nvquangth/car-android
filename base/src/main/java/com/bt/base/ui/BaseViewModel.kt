package com.bt.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bt.base.model.BtException
import com.bt.base.utils.Event

open class BaseViewModel : ViewModel() {

    private val _exceptionEvent = MutableLiveData<Event<BtException>>()
    val exceptionEvent: LiveData<Event<BtException>>
        get() = _exceptionEvent

    private val _showLoadingEvent = MutableLiveData<Event<Unit>>()
    val showLoadingEvent: LiveData<Event<Unit>>
        get() = _showLoadingEvent

    private val _hideLoadingEvent = MutableLiveData<Event<Unit>>()
    val hideLoadingEvent: LiveData<Event<Unit>>
        get() = _hideLoadingEvent

    fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            _showLoadingEvent.value = Event(Unit)
        } else {
            _hideLoadingEvent.value = Event(Unit)
        }
    }

    fun setLoadingAsync(isLoading: Boolean) {
        if (isLoading) {
            _showLoadingEvent.postValue(Event(Unit))
        } else {
            _hideLoadingEvent.postValue(Event(Unit))
        }
    }

    fun setExceptionAsync(exception: BtException) {
        _exceptionEvent.postValue(Event(exception))
    }
}
