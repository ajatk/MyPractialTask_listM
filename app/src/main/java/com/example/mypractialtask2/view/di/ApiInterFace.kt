package com.example.mypractialtask2.view.di

import com.example.mypractialtask2.view.models.UserProjectsPojo
import retrofit2.http.GET

interface ApiInterFace {
    @GET("getUserAssignedProjects")
      fun getUserProjectsData(): UserProjectsPojo
    //
}