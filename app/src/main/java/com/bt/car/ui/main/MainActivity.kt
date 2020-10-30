package com.bt.car.ui.main

import androidx.activity.viewModels
import com.bt.base.ui.BaseActivity
import com.bt.car.R
import com.bt.car.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override val layoutRes: Int = R.layout.activity_main
}
