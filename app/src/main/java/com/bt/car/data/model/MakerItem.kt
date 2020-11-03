package com.bt.car.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MakerItem(
    val name: String,
    val models: List<String>? = null
) : Parcelable
