package com.ysantana.mvp_dagger2_kotlin.data.net.utils

import android.util.Log
import com.google.gson.Gson
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppException
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppHttpException
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppNetworkException
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppUnknownHttpException
import retrofit2.Response
import com.ysantana.mvp_dagger2_kotlin.data.net.models.Error

class ResponseUtils {

    companion object {

        private val TAG: String = ResponseUtils::class.java.simpleName

        fun processError(response: Response<*>): AppException {
            try {
                val errorBody = response.errorBody()?.string() ?: ""
                Log.e(TAG, "processError()$errorBody")
                if (errorBody.isEmpty()) {
                    if (response.code() == 504) {
                        return AppNetworkException(message = "0.- Network error: $errorBody")
                    }
                    return AppUnknownHttpException(message = "1.- Unknown error: $errorBody", ex = null, responseCode = response.code())
                } else {
                    val error = Gson().fromJson(errorBody, Error::class.java)
                    error.code = response.code()
                    return AppHttpException(message = "2.-${error.message} $errorBody", ex = null, responseCode = response.code())
                }
            } catch (ex: Exception) {
                return AppUnknownHttpException(message = "3.- Error parsing message: " + ex.message, ex = ex, responseCode = response.code())
            }
        }
    }
}