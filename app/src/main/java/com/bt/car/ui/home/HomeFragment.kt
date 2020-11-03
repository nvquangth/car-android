package com.bt.car.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.bt.base.ui.BaseFragment
import com.bt.base.uikit.recycler.MarginItemDecoration
import com.bt.car.R
import com.bt.car.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_home

    private var adapter: MakerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMakers()

        with(viewModel) {

            makers.observe(viewLifecycleOwner) {
                adapter?.submitList(it.toMutableList())
            }
        }
    }

    private fun setupMakers() {
        adapter = MakerAdapter(::onItemModelClick)
        recyclerMaker.adapter = adapter
        recyclerMaker.addItemDecoration(MarginItemDecoration(context?.resources?.getDimension(R.dimen.dp_8)?.toInt() ?: 0))
    }

    private fun onItemModelClick(model: String) {

    }
}
