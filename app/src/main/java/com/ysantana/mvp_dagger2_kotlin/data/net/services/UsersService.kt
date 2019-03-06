package com.ysantana.mvp_dagger2_kotlin.data.net.services

import com.ysantana.mvp_dagger2_kotlin.data.DataConfiguration
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable

interface UsersService {
    @GET(DataConfiguration.USERS)
    fun getUsers(): Observable<Response<List<UsersResponse>>>
}