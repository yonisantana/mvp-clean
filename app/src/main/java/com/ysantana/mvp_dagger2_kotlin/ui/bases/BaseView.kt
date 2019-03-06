package com.ysantana.mvp_dagger2_kotlin.ui.bases

import android.content.Context

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun getcontext(): Context
}