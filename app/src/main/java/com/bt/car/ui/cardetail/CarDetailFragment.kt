package com.bt.car.ui.cardetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bt.base.ui.BaseFragment
import com.bt.car.databinding.FragmentCarDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import com.bt.car.R
import com.bt.car.extension.loadImageWithUrl
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.fragment_car_detail.*
import kotlinx.android.synthetic.main.pager_photo.*

@AndroidEntryPoint
class CarDetailFragment : BaseFragment<FragmentCarDetailBinding, CarDetailViewModel>() {

    override val viewModel: CarDetailViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_car_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPager()

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupPager() {
        val urls = listOf(
            "https://img1.oto.com.vn/2020/04/16/pTBR3JY9/gia-xe-mercedes-maybach-s600-oto-com-vn-2-60df.jpg",
            "https://img1.oto.com.vn/2020/04/16/pTBR3JY9/gia-xe-mercedes-maybach-s600-oto-com-vn-4-0384.jpg",
            "https://img1.oto.com.vn/2020/04/16/pTBR3JY9/gia-xe-mercedes-maybach-s600-oto-com-vn-2-60df.jpg",
            "https://img1.oto.com.vn/2020/04/16/pTBR3JY9/gia-xe-mercedes-maybach-s600-oto-com-vn-4-0384.jpg",
            "https://img1.oto.com.vn/2020/04/16/pTBR3JY9/gia-xe-mercedes-maybach-s600-oto-com-vn-2-60df.jpg",
            "https://img1.oto.com.vn/2020/04/16/pTBR3JY9/gia-xe-mercedes-maybach-s600-oto-com-vn-4-0384.jpg"
        )
        val adapter = PhotoPagerApdater(this, urls)
        pagerPhoto.adapter = adapter

        pagerIndicator.apply {
            setSliderColor(ResourcesCompat.getColor(resources, android.R.color.white, null), ResourcesCompat.getColor(resources, R.color.green_200, null))
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(pagerPhoto)
        }
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

    class PhotoPagerApdater(f: Fragment, private val urls: List<String>) : FragmentStateAdapter(f) {
        override fun getItemCount(): Int = urls.size

        override fun createFragment(position: Int): Fragment = PhotoFragment.newInstance(url = urls[position])
    }
}