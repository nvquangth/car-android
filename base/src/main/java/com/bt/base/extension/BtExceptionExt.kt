package com.bt.base.extension

import android.content.Context
import com.bt.base.R
import com.bt.base.exception.AlertException
import com.bt.base.exception.DialogException
import com.bt.base.exception.SnackBarException
import com.bt.base.model.BtException
import com.bt.base.model.BtExceptionCode

fun BtException.parseBtException(context: Context): BtException {
    return when (this.code) {
        BtExceptionCode.BTCODE_DATA_NULL_OR_EMPTY -> AlertException(
            title = context.getString(R.string.notification),
            message = context.getString(R.string.data_empty),
            positiveButton = context.getString(android.R.string.ok)
        )

        BtExceptionCode.BTCODE_NETWORK_NO_CONNECTION -> SnackBarException(
            message = context.getString(R.string.no_internet)
        )
        
        BtExceptionCode.BTCODE_NETWORK_TIMEOUT -> SnackBarException(
            message = context.getString(R.string.connection_timeout)
        )

        BtExceptionCode.BTCODE_APP_SERVER_MAINTENANCE -> DialogException(
            title = context.getString(R.string.server_maintenance),
            message = context.getString(R.string.server_maintenance_message),
            positiveButton = context.getString(R.string.try_later),
            code = this.code
        )

        BtExceptionCode.BTCODE_APP_FORCE_UPDATE -> DialogException(
            title = context.getString(R.string.new_version_app),
            message = context.getString(R.string.new_version_app_message),
            positiveButton = context.getString(R.string.update),
            negativeButton = context.getString(R.string.no_thank),
            code = this.code
        )

        BtExceptionCode.BTCODE_APP_LOGIN_FAIL -> AlertException(
            title = context.getString(R.string.notification),
            message = context.getString(R.string.login_fail),
            positiveButton = context.getString(android.R.string.ok)
        )

        else -> BtException()
    }
}
