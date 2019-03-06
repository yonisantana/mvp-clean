package com.ysantana.mvp_dagger2_kotlin.data

class DataConfiguration {
    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val USERS = "$BASE_URL/users"
    }

    fun getBaseUrl() = BASE_URL
}