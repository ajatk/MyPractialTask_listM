package com.example.mypractialtask2.view.di

import com.example.mypractialtask2.view.models.ProjectTempletePojo
import com.example.mypractialtask2.view.models.UserProjectsPojo
import javax.inject.Inject

class ProjectsRepository @Inject constructor(val apiInterFace: ApiInterFace) {

    suspend fun projectsData1():  UserProjectsPojo {
        return apiInterFace.getUserProjectsData()
    }
    suspend fun projectsTempleteData1(pageno:String,docid:String,issue_id:String,pid:String,recurrence:String,clone:String):  ProjectTempletePojo {
        return apiInterFace.getUserTempleteProjectsData(pageno,docid,issue_id,pid,recurrence,clone)
    }

}