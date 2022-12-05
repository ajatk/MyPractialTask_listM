package com.example.mypractialtask2.view.models

data class UserProjectsPojo(
    val authToken: String,
    val `data`: Data,
    val datalimit: Any,
    val message: String,
    val success: Boolean
)