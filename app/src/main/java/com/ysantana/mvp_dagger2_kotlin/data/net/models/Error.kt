package com.ysantana.mvp_dagger2_kotlin.data.net.models

import com.google.gson.annotations.SerializedName
import com.ysantana.mvp_dagger2_kotlin.domain.models.BaseBean

class Error : BaseBean() {
    @SerializedName(value = "message", alternate = arrayOf("error", "fullMessage"))
    var message: String = ""
    @SerializedName(value = "code", alternate = arrayOf("status_code"))
    var code: Int = 0
}