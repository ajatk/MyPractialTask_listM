package com.example.mypractialtask2.commons.utils

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("message")
    var message: String = "",
    @SerializedName("status")
    var status: Int = 0,
)