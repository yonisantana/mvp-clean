package com.ysantana.mvp_dagger2_kotlin.ui.users

import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppException
import com.ysantana.mvp_dagger2_kotlin.domain.interactors.UsersInteractor
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import com.ysantana.mvp_dagger2_kotlin.ui.bases.BasePresenter
import javax.inject.Inject

class UsersPresenter @Inject constructor(
    private val usersInteractor: UsersInteractor
) : BasePresenter<UsersView>(), UsersInteractor.UsersListener {

    init {
        usersInteractor.setUsersListener(this)
    }

    fun getUsers() {
        getView()?.let {
            it.showLoading()
            usersInteractor.getUsers()
        }
    }

    override fun onUsersSuccess(response: List<UsersResponse>) {
        getView()?.let {
            it.hideLoading()
            it.showUsers(response)
        }
    }

    override fun onUsersError(throwable: AppException) {
        getView()?.let {
            it.hideLoading()
            it.showUsersError(throwable)
        }
    }

    override fun pause() {
        usersInteractor.stop()
    }
}