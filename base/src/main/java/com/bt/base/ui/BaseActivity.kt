package com.bt.base.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.preference.PreferenceManager
import com.bt.base.R
import com.bt.base.BR
import com.bt.base.uikit.ThemeHelper

abstract class BaseActivity<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : AppCompatActivity() {

    lateinit var viewBinding: ViewBinding

    abstract val viewModel: ViewModel

//    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @get:LayoutRes
    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
//        applyTheme()
        super.onCreate(savedInstanceState)

//        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        viewBinding = DataBindingUtil.setContentView(this, layoutRes)
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@BaseActivity
            executePendingBindings()
        }
    }

    private fun applyTheme() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        when (sharedPreferences.getString(ThemeHelper.THEME_PREF, ThemeHelper.COLOR_1) ?: ThemeHelper.COLOR_1) {
            ThemeHelper.COLOR_1 -> setTheme(R.style.Theme_MyApp_COLOR1)
            ThemeHelper.COLOR_2 -> setTheme(R.style.Theme_MyApp_COLOR2)
            ThemeHelper.COLOR_3 -> setTheme(R.style.Theme_MyApp_COLOR3)
            ThemeHelper.COLOR_4 -> setTheme(R.style.Theme_MyApp_COLOR4)
            ThemeHelper.COLOR_5 -> setTheme(R.style.Theme_MyApp_COLOR5)
            ThemeHelper.COLOR_6 -> setTheme(R.style.Theme_MyApp_COLOR6)
            ThemeHelper.COLOR_7 -> setTheme(R.style.Theme_MyApp_COLOR7)
            ThemeHelper.COLOR_8 -> setTheme(R.style.Theme_MyApp_COLOR8)
            else -> setTheme(R.style.Theme_MyApp_COLOR9)
        }

        when (sharedPreferences.getString(ThemeHelper.THEME_MODE_PREF, ThemeHelper.DEFAULT_MODE) ?: ThemeHelper.DEFAULT_MODE) {
            ThemeHelper.LIGHT_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            ThemeHelper.DARK_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                }
            }
        }
    }

    fun track(action: String?) {
//        if (!action.isNullOrEmpty()) {
//            val msg = "open_${action.toLowerCase(Locale.ROOT).replace(" ", "_")}"
//            firebaseAnalytics.logEvent(msg, Bundle())
//        }
    }
}
