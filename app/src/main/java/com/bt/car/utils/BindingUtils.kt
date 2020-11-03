package com.bt.car.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("glideCircle")
fun ImageView.setImageCircle(url: String) {
    GlideApp.with(context)
        .load(url)
        .apply(RequestOptions.bitmapTransform(CircleCrop()))
        .into(this)
}
