package com.bt.car.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.bt.base.ui.BaseRecyclerAdapter
import com.bt.car.R
import com.bt.car.data.model.MakerItem
import com.bt.car.databinding.ItemMakerBinding

class MakerAdapter(
    private val listener: ((String) -> Unit)? = null
): BaseRecyclerAdapter<MakerItem, ItemMakerBinding>(object : DiffUtil.ItemCallback<MakerItem>() {
    override fun areContentsTheSame(oldItem: MakerItem, newItem: MakerItem): Boolean = oldItem == newItem

    override fun areItemsTheSame(oldItem: MakerItem, newItem: MakerItem): Boolean = oldItem.name == newItem.name
}) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_maker

    override fun bindFirstTime(binding: ItemMakerBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.let {
                    listener?.invoke(it.name)
                }
            }

            buttonExpand.setOnClickListener {

            }
        }
    }
}