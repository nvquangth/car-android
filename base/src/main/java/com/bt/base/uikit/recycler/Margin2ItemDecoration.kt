package com.bt.base.uikit.recycler

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class Margin2ItemDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val lastItemPosition = parent.adapter?.itemCount?.minus(1)
        if (position % 2 != 0) {
            outRect.left = margin / 2
            outRect.right = margin
            outRect.top = margin
        } else {
            outRect.left = margin
            outRect.right = margin / 2
            outRect.top = margin
        }
        if (position == lastItemPosition) {
            outRect.bottom = margin
        }
    }
}