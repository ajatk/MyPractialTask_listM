package com.example.mypractialtask2.view.models

data class ProjectTempletePojo(
    val authToken: String,
    val data: List<DataX>,
    val dataHeader: DataHeader,
    val datalimit: Any,
    val isStagedDocument: Boolean,
    val message: String,
    val overdueDates: List<Any>,
    val success: Boolean
)