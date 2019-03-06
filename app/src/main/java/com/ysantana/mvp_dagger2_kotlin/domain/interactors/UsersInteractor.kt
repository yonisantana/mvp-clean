package com.ysantana.mvp_dagger2_kotlin.domain.interactors

import com.ysantana.mvp_dagger2_kotlin.data.repository.UsersRepository
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppException
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppUnknownHttpException
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersInteractor @Inject constructor(private val usersRepository: UsersRepository) {

    private var subscription: Subscription? = null
    private var usersListener: UsersListener? = null

    fun setUsersListener(usersListener: UsersListener) {
        this.usersListener = usersListener
    }

    fun getUsers() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                usersListener?.onUsersSuccess(it)
            }, {
                usersListener?.onUsersError(parseException(it))
            })
    }

    fun stop() {
        subscription?.unsubscribe()
    }

    private fun parseException(throwable: Throwable) =
        if (throwable is IOException) AppUnknownHttpException() else throwable as AppException

    interface UsersListener {
        fun onUsersSuccess(response: List<UsersResponse>)
        fun onUsersError(throwable: AppException)
    }
}