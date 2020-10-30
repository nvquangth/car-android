package com.bt.base.extension

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
//import androidx.navigation.NavController
//import androidx.navigation.fragment.NavHostFragment

//fun FragmentActivity.findNavController(navHostFragmentId: Int): NavController = (this.supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment).navController

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
