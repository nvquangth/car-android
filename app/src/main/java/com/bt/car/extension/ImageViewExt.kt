package com.bt.car.extension

import android.widget.ImageView
import com.bt.car.utils.GlideApp
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImageWithUrl(url: String) {
    GlideApp.with(this)
        .load(url)
        .into(this)
}

fun ImageView.loadImageWithResource(res: Int) {
    GlideApp.with(this)
        .load(res)
        .into(this)
}

fun ImageView.loadCircleImageWithUrl(url: String) {
    GlideApp.with(this)
        .load(url)
        .apply(RequestOptions.bitmapTransform(CircleCrop()))
        .into(this)
}

fun ImageView.loadCircleImageWithResource(res: Int) {
    GlideApp.with(this)
        .load(res)
        .apply(RequestOptions.bitmapTransform(CircleCrop()))
        .into(this)
}
