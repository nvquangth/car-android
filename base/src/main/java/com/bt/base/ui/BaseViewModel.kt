package com.bt.base.ui

import androidx.lifecycle.ViewModel
import com.bt.base.utils.SingleLiveEvent
import com.bt.base.model.BtException

open class BaseViewModel : ViewModel() {

    val exceptionEvent = SingleLiveEvent<BtException>()

    val loading = SingleLiveEvent<Boolean>().apply { value = false }

    fun showLoading() {
        if (loading.value == true) return
        loading.postValue(true)
    }

    fun hideLoading() {
        if (loading.value == false) return
        loading.postValue(false)
    }
}
