package com.bt.base.ui

import androidx.lifecycle.ViewModel
import com.bt.base.utils.SingleLiveEvent
import com.bt.base.model.BtException

open class BaseViewModel : ViewModel() {

    val exceptionEvent = SingleLiveEvent<BtException>()
}
