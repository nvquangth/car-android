package com.bt.car.ui.cardetail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bt.base.ui.BaseFragment
import com.bt.base.ui.BaseRecyclerAdapter
import com.bt.base.uikit.recycler.CenterDecoration
import com.bt.base.uikit.recycler.CenterSnapHelper
import com.bt.base.uikit.recycler.CenterZoomLayoutManager
import com.bt.car.R
import com.bt.car.data.model.InfoItem
import com.bt.car.databinding.FragmentCarDetailBinding
import com.bt.car.databinding.ItemInfoBinding
import com.bt.car.databinding.ItemModelDetailBinding
import com.bt.car.databinding.PagerInfoBinding
import com.bt.car.extension.loadImageWithUrl
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_car_detail.*
import kotlinx.android.synthetic.main.pager_info.*
import kotlinx.android.synthetic.main.pager_photo.*

@AndroidEntryPoint
class CarDetailFragment : BaseFragment<FragmentCarDetailBinding, CarDetailViewModel>() {

    override val viewModel: CarDetailViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_car_detail

    private val centerSnapHelper = CenterSnapHelper()
    private var modelAdapter: ModelAdapter? = null
    private var infoPagerAdapter: InfoPagerAdapter? = null
    private val pagerInfoCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            centerSnapHelper.scrollTo(position, true)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPhotoPager()
        setupModelRecycler()
        setupInfoPager()

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        val safeArgs: CarDetailFragmentArgs by navArgs()
        val maker = safeArgs.maker

        with(viewModel) {
            setMaker(maker)

            models.observe(viewLifecycleOwner) {
                modelAdapter?.submitList(it.toMutableList())
                infoPagerAdapter?.setModels(it)
            }
        }
    }

    override fun onDestroyView() {
        pagerInfo.unregisterOnPageChangeCallback(pagerInfoCallback)
        super.onDestroyView()
    }

    private fun setupPhotoPager() {
        val urls = listOf(
            "https://drscdn.500px.org/photo/41149196/q%3D80_m%3D2000/v2?sig=b8d6804c7b0ce82964b3208fd722c437cdc5c50d6e1c86df0a3c26da2c6efc2d",
            "https://drscdn.500px.org/photo/41149196/q%3D80_m%3D2000/v2?sig=b8d6804c7b0ce82964b3208fd722c437cdc5c50d6e1c86df0a3c26da2c6efc2d",
            "https://drscdn.500px.org/photo/41149196/q%3D80_m%3D2000/v2?sig=b8d6804c7b0ce82964b3208fd722c437cdc5c50d6e1c86df0a3c26da2c6efc2d",
            "https://drscdn.500px.org/photo/41149196/q%3D80_m%3D2000/v2?sig=b8d6804c7b0ce82964b3208fd722c437cdc5c50d6e1c86df0a3c26da2c6efc2d",
            "https://drscdn.500px.org/photo/41149196/q%3D80_m%3D2000/v2?sig=b8d6804c7b0ce82964b3208fd722c437cdc5c50d6e1c86df0a3c26da2c6efc2d",
            "https://drscdn.500px.org/photo/41149196/q%3D80_m%3D2000/v2?sig=b8d6804c7b0ce82964b3208fd722c437cdc5c50d6e1c86df0a3c26da2c6efc2d"
        )
        val adapter = PhotoPagerAdapter(this, urls)
        pagerPhoto.adapter = adapter

        pagerIndicator.apply {
            setSliderColor(ResourcesCompat.getColor(resources, android.R.color.white, null), ResourcesCompat.getColor(resources, R.color.green_200, null))
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(pagerPhoto)
        }
    }

    private fun setupModelRecycler() {
        modelAdapter = ModelAdapter(::onItemModelClick)
        with(recyclerModel) {
            adapter = modelAdapter
            layoutManager = CenterZoomLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(CenterDecoration(0))
            centerSnapHelper.attachToRecyclerView(this)
        }
    }

    private fun setupInfoPager() {
        infoPagerAdapter = InfoPagerAdapter(this)
        pagerInfo.adapter = infoPagerAdapter
        pagerInfo.registerOnPageChangeCallback(pagerInfoCallback)
    }

    private fun onItemModelClick(model: String, position: Int) {
        centerSnapHelper.scrollTo(position, true)
        pagerInfo.currentItem = position
    }

    class PhotoFragment : Fragment() {

        companion object {

            private const val ARGUMENT_URL = "argument_url"

            fun newInstance(url: String): PhotoFragment = PhotoFragment().apply {
                arguments = bundleOf(ARGUMENT_URL to url)
            }
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.pager_photo, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val url = arguments?.getString(ARGUMENT_URL) ?: ""
            imageCar.loadImageWithUrl(url)
        }
    }

    @AndroidEntryPoint
    class InfoFragment : BaseFragment<PagerInfoBinding, CarDetailViewModel>() {

        private var adapter: InfoAdapter? = null

        companion object {

            private const val ARGUMENT_MODEL = "argument_car"

            fun newInstance(model: String) = InfoFragment().apply {
                arguments = bundleOf(ARGUMENT_MODEL to model)
            }
        }

        override val viewModel: CarDetailViewModel by viewModels()

        override val layoutRes: Int = R.layout.pager_info

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            setupInfoRecycler()

            with(viewModel) {
                info.observe(viewLifecycleOwner) {
                    adapter?.submitList(it.toMutableList())
                }
            }

            val model = arguments?.getString(ARGUMENT_MODEL) ?: ""
            viewModel.getInfo(model)
        }

        private fun setupInfoRecycler() {
            adapter = InfoAdapter()
            recyclerInfo.adapter = adapter
        }
    }

    private class PhotoPagerAdapter(f: Fragment, private val urls: List<String>) : FragmentStateAdapter(f) {
        override fun getItemCount(): Int = urls.size

        override fun createFragment(position: Int): Fragment = PhotoFragment.newInstance(url = urls[position])
    }

    private class InfoPagerAdapter(f: Fragment) : FragmentStateAdapter(f) {
        private var models = emptyList<String>()
        override fun getItemCount(): Int = models.size

        override fun createFragment(position: Int): Fragment = InfoFragment.newInstance(model = models[position])

        fun setModels(data: List<String>) {
            models = data
            notifyDataSetChanged()
        }
    }

    private class ModelAdapter(private val listener: ((String, Int) -> Unit)? = null) : BaseRecyclerAdapter<String, ItemModelDetailBinding>(
        object : DiffUtil.ItemCallback<String>() {
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        }
    ) {
        override fun getLayoutRes(viewType: Int): Int = R.layout.item_model_detail

        override fun bindView(binding: ItemModelDetailBinding, item: String, position: Int) {
            binding.apply {
                root.setOnClickListener {
                    listener?.invoke(item, position)
                }
            }
        }
    }

    private class InfoAdapter : BaseRecyclerAdapter<InfoItem, ItemInfoBinding>(
        object : DiffUtil.ItemCallback<InfoItem>() {
            override fun areContentsTheSame(oldItem: InfoItem, newItem: InfoItem): Boolean = oldItem == newItem

            override fun areItemsTheSame(oldItem: InfoItem, newItem: InfoItem): Boolean = oldItem.title == newItem.title
        }
    ) {
        override fun getLayoutRes(viewType: Int): Int = R.layout.item_info

        override fun bindView(binding: ItemInfoBinding, item: InfoItem, position: Int) {
            if (position % 2 == 0) {
                binding.root.setBackgroundColor(ResourcesCompat.getColor(binding.root.resources, R.color.gray_100, null))
            } else {
                binding.root.setBackgroundColor(Color.WHITE)
            }
        }
    }
}
