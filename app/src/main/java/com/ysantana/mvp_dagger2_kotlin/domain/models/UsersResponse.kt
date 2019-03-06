package com.ysantana.mvp_dagger2_kotlin.domain.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UsersResponse(

    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("website")
    var website: String? = null,
    @SerializedName("phone")
    var phone: String? = null
) : RealmObject()