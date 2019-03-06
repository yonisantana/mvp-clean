package com.ysantana.mvp_dagger2_kotlin.di.modules

import android.content.Context
import com.ysantana.mvp_dagger2_kotlin.MyApp
import com.ysantana.mvp_dagger2_kotlin.data.DataConfiguration
import com.ysantana.mvp_dagger2_kotlin.data.NetworkManager
import com.ysantana.mvp_dagger2_kotlin.data.RealmManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApp) {

    @Provides
    @Singleton
    fun providesApplication(): MyApp = application

    @Provides
    @Singleton
    fun providesContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesDataConfiguration(): DataConfiguration = DataConfiguration()

    @Provides
    @Singleton
    fun providesNetworkManager(): NetworkManager = NetworkManager(application)

    @Provides
    @Singleton
    fun providesRealmManager(): RealmManager = RealmManager()

}