package com.ysantana.mvp_dagger2_kotlin.domain.exception

open class AppHttpException : AppException {
    var responseCode: Int = -1

    constructor(message: String = "Unknown error") : super(message)
    constructor(message: String = "Unknown error", ex: Throwable?, responseCode: Int) : super(message, ex) {
        this.responseCode = responseCode
    }
}