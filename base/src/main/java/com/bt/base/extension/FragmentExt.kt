package com.bt.base.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.hideKeyBoard() {
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun Fragment.showKeyBoard() {
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun Fragment.toast(msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}
