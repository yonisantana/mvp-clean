package com.ysantana.mvp_dagger2_kotlin.di.components

import com.ysantana.mvp_dagger2_kotlin.di.modules.ApplicationModule
import com.ysantana.mvp_dagger2_kotlin.di.modules.DataModule
import com.ysantana.mvp_dagger2_kotlin.di.modules.InteractorModule
import com.ysantana.mvp_dagger2_kotlin.di.modules.NetworkModule
import com.ysantana.mvp_dagger2_kotlin.ui.users.UsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(DataModule::class), (NetworkModule::class), (InteractorModule::class), (ApplicationModule::class)])
interface ApplicationComponent {
    fun inject(usersFragment: UsersFragment)
}