package com.ysantana.mvp_dagger2_kotlin.domain.models

import com.google.gson.GsonBuilder
import java.io.Serializable

open class BaseBean : Serializable {
    override fun toString(): String {
        val gson = GsonBuilder().create()
        return gson.toJson(this)
    }
}