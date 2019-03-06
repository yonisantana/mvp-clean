package com.ysantana.mvp_dagger2_kotlin.di.modules

import com.ysantana.mvp_dagger2_kotlin.data.repository.UsersRepository
import com.ysantana.mvp_dagger2_kotlin.domain.interactors.UsersInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesUserInteractor(usersRepository: UsersRepository): UsersInteractor {
        return UsersInteractor(usersRepository)
    }
}