package com.ysantana.mvp_dagger2_kotlin

import android.support.multidex.MultiDexApplication
import com.ysantana.mvp_dagger2_kotlin.di.components.ApplicationComponent
import com.ysantana.mvp_dagger2_kotlin.di.components.DaggerApplicationComponent
import com.ysantana.mvp_dagger2_kotlin.di.modules.ApplicationModule
import io.realm.Realm

class MyApp  : MultiDexApplication(){

    companion object {
        @JvmStatic
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initRealm()
        initDependencies()
    }

    private fun initDependencies() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    private fun initRealm() {
        Realm.init(this)
    }
}
