package com.ysantana.mvp_dagger2_kotlin.data.repository

import com.ysantana.mvp_dagger2_kotlin.data.NetworkManager
import com.ysantana.mvp_dagger2_kotlin.data.RealmManager
import com.ysantana.mvp_dagger2_kotlin.data.net.NetUsersEntity
import com.ysantana.mvp_dagger2_kotlin.data.net.services.UsersService
import com.ysantana.mvp_dagger2_kotlin.data.realm.RealmUsersEntity
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import rx.Observable
import javax.inject.Inject

class UsersRepositoryFactory @Inject constructor(
    private val networkManager: NetworkManager,
    realmManager: RealmManager,
    service: UsersService
) : UsersRepository {

    private var netUsersEntity: NetUsersEntity? = null
    private var realmUsersEntity: RealmUsersEntity? = null

    init {
        netUsersEntity = NetUsersEntity(service, realmManager)
        realmUsersEntity = RealmUsersEntity(realmManager)
    }

    override fun getUsers(): Observable<List<UsersResponse>> {
        return if (networkManager.isNetworkAvailable()) netUsersEntity!!.getUsers()
        else realmUsersEntity!!.getUsers()
    }
}