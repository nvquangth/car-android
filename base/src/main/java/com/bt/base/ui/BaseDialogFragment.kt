package com.bt.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.bt.base.R
import com.bt.base.BR

/**
 *   Created by quangnv on 17/03/2019
 */

abstract class BaseDialogFragment<ViewBinding : ViewDataBinding, V : BaseViewModel> : DialogFragment() {

    abstract val viewModel: ViewModel

    lateinit var viewBinding: ViewBinding

    @get:LayoutRes
    abstract val layoutRes: Int

    open var isFullScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isFullScreen) {
//            setStyle(STYLE_NO_FRAME, R.style.AppTheme_FullScreenDialog)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
            lifecycleOwner = this@BaseDialogFragment
        }
    }
}
