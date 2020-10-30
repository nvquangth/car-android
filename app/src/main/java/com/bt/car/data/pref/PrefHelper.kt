package com.bt.car.data.pref

interface PrefHelper {

    /**
     * remove a preference by key
     */
    fun remove(key: String)

    /**
     * clear all preference
     */
    fun clear()

    suspend fun isFirstOpenApp(): Boolean

    suspend fun setFirstOpenApp(value: Boolean)
}
