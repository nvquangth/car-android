package com.bt.base.exception

import com.bt.base.model.BtException
import com.bt.base.model.BtExceptionCode

class AlertException(
    override val code: BtExceptionCode? = null,
    override val message: String? = null,
    val title: String? = null,
    val positiveButton: String? = null,
    val negativeButton: String? = null
) : BtException(code, message)
