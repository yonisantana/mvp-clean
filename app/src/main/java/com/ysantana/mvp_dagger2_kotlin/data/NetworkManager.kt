package com.ysantana.mvp_dagger2_kotlin.data

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

class NetworkManager(val context: Context) {
    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}