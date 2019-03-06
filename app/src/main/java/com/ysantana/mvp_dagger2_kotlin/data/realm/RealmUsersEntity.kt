package com.ysantana.mvp_dagger2_kotlin.data.realm

import com.ysantana.mvp_dagger2_kotlin.data.RealmManager
import com.ysantana.mvp_dagger2_kotlin.data.repository.UsersRepository
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import rx.Observable

class RealmUsersEntity(private val realmManager: RealmManager) : UsersRepository {
    override fun getUsers(): Observable<List<UsersResponse>> {
        return Observable.just(realmManager.findAll(UsersResponse::class.java))
    }
}