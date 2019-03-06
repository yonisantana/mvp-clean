package com.ysantana.mvp_dagger2_kotlin.data.repository

import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import rx.Observable

interface UsersRepository {
    fun getUsers(): Observable<List<UsersResponse>>
}