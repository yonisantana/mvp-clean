package com.ysantana.mvp_dagger2_kotlin.di.modules

import com.ysantana.mvp_dagger2_kotlin.data.NetworkManager
import com.ysantana.mvp_dagger2_kotlin.data.RealmManager
import com.ysantana.mvp_dagger2_kotlin.data.net.services.UsersService
import com.ysantana.mvp_dagger2_kotlin.data.repository.UsersRepository
import com.ysantana.mvp_dagger2_kotlin.data.repository.UsersRepositoryFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideUsersRepository(retrofit: Retrofit, networkManager: NetworkManager, realmManager: RealmManager): UsersRepository {
        return UsersRepositoryFactory(
            networkManager,
            realmManager,
            retrofit.create(UsersService::class.java)
        )
    }
}