package com.ysantana.mvp_dagger2_kotlin.domain.exception

open class AppException : Exception {
    constructor(ex: Exception) : super(ex)
    constructor(message: String = "") : super(message)
    constructor(message: String = "", ex: Throwable?) : super(message, ex)
}