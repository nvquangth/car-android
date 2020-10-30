package com.bt.car.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Car(
    @PrimaryKey
    val id: Int
) : Parcelable
