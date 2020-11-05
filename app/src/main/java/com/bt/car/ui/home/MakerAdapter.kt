package com.bt.car.ui.home

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.bt.base.ui.BaseRecyclerAdapter
import com.bt.car.R
import com.bt.car.data.model.MakerItem
import com.bt.car.databinding.ItemMakerBinding
import com.bt.car.databinding.ItemModelBinding
import com.bt.car.extension.loadCircleImageWithResource
import com.bt.car.utils.GlideApp
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class MakerAdapter(
    private val listener: ((String) -> Unit)? = null
) : BaseRecyclerAdapter<MakerItem, ItemMakerBinding>(
    object : DiffUtil.ItemCallback<MakerItem>() {
        override fun areContentsTheSame(oldItem: MakerItem, newItem: MakerItem): Boolean = oldItem == newItem

        override fun areItemsTheSame(oldItem: MakerItem, newItem: MakerItem): Boolean = oldItem.name == newItem.name
    }
) {
    private val expandMakerMap = HashMap<String, Boolean>()

    override fun getLayoutRes(viewType: Int): Int = R.layout.item_maker

    override fun bindFirstTime(binding: ItemMakerBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.let {
                    listener?.invoke(it.name)
                }
            }

            buttonExpand.setOnClickListener {
                item?.let {
                    if (expandMakerMap[it.name] == true) {
                        buttonExpand.setImageResource(R.drawable.ic_baseline_expand_more_24)
                        recyclerModel.visibility = View.GONE
                        viewBgHeader.visibility = View.GONE
                        cardMaker.isEnabled = true
                    } else {
                        buttonExpand.setImageResource(R.drawable.ic_baseline_expand_less_24)
                        recyclerModel.visibility = View.VISIBLE
                        viewBgHeader.visibility = View.VISIBLE
                        cardMaker.isEnabled = false
                    }
                    expandMakerMap[it.name] = expandMakerMap[it.name]?.not() ?: true
                }
            }
        }
    }

    override fun bindView(binding: ItemMakerBinding, item: MakerItem, position: Int) {
        binding.apply {

            val adapter = ModelAdapter()
            recyclerModel.adapter = adapter
            adapter.submitList(item.models?.toMutableList())

            if (expandMakerMap[item.name] == true) {
                buttonExpand.setImageResource(R.drawable.ic_baseline_expand_less_24)
                recyclerModel.visibility = View.VISIBLE
                viewBgHeader.visibility = View.VISIBLE
                cardMaker.isEnabled = false
            } else {
                buttonExpand.setImageResource(R.drawable.ic_baseline_expand_more_24)
                recyclerModel.visibility = View.GONE
                viewBgHeader.visibility = View.GONE
                cardMaker.isEnabled = true
            }

            imageLogo.loadCircleImageWithResource(R.drawable.icon_bmw)
        }
    }

    class ModelAdapter(
        private val listener: ((String) -> Unit)? = null
    ) : BaseRecyclerAdapter<String, ItemModelBinding>(
        object : DiffUtil.ItemCallback<String>() {

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        }
    ) {

        override fun getLayoutRes(viewType: Int): Int = R.layout.item_model

        override fun bindFirstTime(binding: ItemModelBinding) {
            binding.apply {
                root.setOnClickListener {
                    item?.let {
                        listener?.invoke(it)
                    }
                }
            }
        }
    }
}
