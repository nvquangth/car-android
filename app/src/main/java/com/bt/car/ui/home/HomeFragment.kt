package com.bt.car.ui.home

import androidx.fragment.app.viewModels
import com.bt.base.ui.BaseFragment
import com.bt.car.R
import com.bt.car.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_home
}
