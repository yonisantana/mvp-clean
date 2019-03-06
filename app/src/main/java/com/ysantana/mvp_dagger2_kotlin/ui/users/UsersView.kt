package com.ysantana.mvp_dagger2_kotlin.ui.users

import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppException
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import com.ysantana.mvp_dagger2_kotlin.ui.bases.BaseView

interface UsersView : BaseView {
    fun showUsers(response: List<UsersResponse>)
    fun showUsersError(throwable: AppException)
}