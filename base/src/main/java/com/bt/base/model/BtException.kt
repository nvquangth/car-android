package com.bt.base.model

open class BtException(
    open val code: BtExceptionCode? = null,
    override val message: String? = null
) : Throwable(message)
