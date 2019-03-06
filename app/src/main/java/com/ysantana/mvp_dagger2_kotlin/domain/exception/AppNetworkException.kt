package com.ysantana.mvp_dagger2_kotlin.domain.exception

open class AppNetworkException : AppException {
    constructor(message: String = "Network error") : super(message)
}