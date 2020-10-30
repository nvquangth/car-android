package com.bt.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.bt.base.exception.AlertException
import com.bt.base.exception.DialogException
import com.bt.base.exception.SnackBarException
import com.bt.base.exception.ToastException
import com.bt.base.extension.parseBtException
import com.bt.base.model.BtExceptionCode
import com.bt.base.BR

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {

    lateinit var viewBinding: ViewBinding

    abstract val viewModel: ViewModel

    @get:LayoutRes
    abstract val layoutRes: Int

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
            root.isClickable = true
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }

        with(viewModel) {
            exceptionEvent.observe(viewLifecycleOwner) {
                when (val e = it.parseBtException(requireContext())) {
                    is AlertException -> {
                        showAlertException(e)
                    }

                    is SnackBarException -> {
                        showSnackBarException(e, view)
                    }

                    is DialogException -> {
                        showDialogException(e)
                    }

                    is ToastException -> {
                    }
                }
            }
        }
    }

    open fun showToastException(
        e: ToastException
    ) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    open fun showAlertException(
        e: AlertException
    ) {
        MaterialAlertDialogBuilder(context ?: return)
            .setTitle(e.title)
            .setMessage(e.message)
            .setPositiveButton(e.positiveButton) { _, _ ->
            }
            .show()
    }

    open fun showSnackBarException(
        e: SnackBarException,
        view: View
    ) {
        Snackbar.make(view, e.message ?: "", Snackbar.LENGTH_SHORT)
            .show()
    }

    open fun showDialogException(
        e: DialogException,
        positiveAction: (() -> Unit)? = null,
        negativeAction: (() -> Unit)? = null
    ) {
        MaterialAlertDialogBuilder(context ?: return)
            .setTitle(e.title)
            .setMessage(e.message)
            .setPositiveButton(e.positiveButton) { _, _ ->
                when (e.code) {
                    BtExceptionCode.BTCODE_APP_SERVER_MAINTENANCE -> activity?.finish()
                    BtExceptionCode.BTCODE_APP_FORCE_UPDATE -> openAppOnPlayStore()
                    else -> positiveAction?.invoke()
                }
            }
            .setNegativeButton(e.negativeButton) { _, _ ->
                negativeAction?.invoke()
            }
            .setCancelable(false)
            .show()
    }

    fun openAppOnPlayStore() {
    }

    open fun track(msg: String) {}
}
