package com.bt.car.data.pref

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson

/**
 *   Created by quangnv on 25/01/2019
 */

class PrefHelperImpl(
    private val pref: SharedPreferences,
    private val gson: Gson
) : PrefHelper {

    companion object {
        private const val PREF_FIRST_OPEN_APP = "PREF_FIRST_OPEN_APP"
    }

    override fun remove(key: String) {
        pref.edit {
            remove(key)
        }
    }

    override fun clear() {
        pref.edit {
            clear()
        }
    }

    override suspend fun isFirstOpenApp(): Boolean = pref.getBoolean(PREF_FIRST_OPEN_APP, false)

    override suspend fun setFirstOpenApp(value: Boolean) {
        pref.edit {
            putBoolean(PREF_FIRST_OPEN_APP, value)
        }
    }
}
