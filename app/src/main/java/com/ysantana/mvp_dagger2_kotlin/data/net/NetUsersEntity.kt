package com.ysantana.mvp_dagger2_kotlin.data.net

import com.ysantana.mvp_dagger2_kotlin.data.RealmManager
import com.ysantana.mvp_dagger2_kotlin.data.repository.UsersRepository
import com.ysantana.mvp_dagger2_kotlin.data.net.services.UsersService
import com.ysantana.mvp_dagger2_kotlin.data.net.utils.ResponseUtils
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import retrofit2.Response
import rx.Observable
import rx.functions.Func1

class NetUsersEntity(private val service: UsersService, private val realmManager: RealmManager) : UsersRepository {
    override fun getUsers(): Observable<List<UsersResponse>> {
        return service.getUsers()
            .flatMap(Func1<Response<List<UsersResponse>>, Observable<List<UsersResponse>>> {
                if (it.isSuccessful) {
                    val response = it.body()!!
                    realmManager.saveAll(response)
                    return@Func1 Observable.just(response)
                } else {
                    return@Func1 Observable.error(ResponseUtils.processError(it))
                }
            })
    }
}