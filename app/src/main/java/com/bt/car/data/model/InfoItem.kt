package com.bt.car.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoItem(
    val title: String,
    val value: String? = null
) : Parcelable