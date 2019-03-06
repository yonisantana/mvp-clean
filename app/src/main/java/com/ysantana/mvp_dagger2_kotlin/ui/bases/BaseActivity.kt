package com.ysantana.mvp_dagger2_kotlin.ui.bases

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initFragment()
    }

    @LayoutRes
    abstract fun getLayout(): Int

    @IdRes
    abstract fun getContainer(): Int

    abstract fun getInitialFragment(): Fragment?

    private fun initFragment() {
        if (getContainer() != 0) {
            val fm = getInitialFragment()
            if (fm != null) {
                val ft = supportFragmentManager.beginTransaction()
                ft.add(getContainer(), fm)
                ft.commitAllowingStateLoss()
            }
        }
    }
}