package com.example.mypractialtask2.view.di

import com.example.mypractialtask2.view.models.UserProjectsPojo
import javax.inject.Inject

class ProjectsRepository @Inject constructor(val apiInterFace: ApiInterFace) {

    suspend fun projectsData1():  UserProjectsPojo {
        return apiInterFace.getUserProjectsData()
    }
}