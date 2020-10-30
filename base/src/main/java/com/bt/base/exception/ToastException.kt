package com.bt.base.exception

import com.bt.base.model.BtException
import com.bt.base.model.BtExceptionCode

class ToastException(
    override val code: BtExceptionCode? = null,
    override val message: String? = null
) : BtException(code, message)
