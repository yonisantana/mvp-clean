package com.ysantana.mvp_dagger2_kotlin

import android.os.Bundle
import com.ysantana.mvp_dagger2_kotlin.ui.bases.BaseActivity
import com.ysantana.mvp_dagger2_kotlin.ui.users.UsersFragment

class UsersActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayout() = R.layout.activity_users

    override fun getContainer() = R.id.flContainer

    override fun getInitialFragment() = UsersFragment.newInstance()
}
