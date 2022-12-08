package com.example.mypractialtask2.view.di

import com.example.mypractialtask2.view.models.ProjectTempletePojo
import com.example.mypractialtask2.view.models.UserProjectsPojo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterFace {
    @Headers("authtoken: eyJ0eXBlIjoiQlMiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzaXRlaWQiOiJkbFZQV0V0aEwzcG1SMkpFUVc1NFpsYzJaREpSWnowOSIsImRldmljZW5vIjoiWm1OQmVtOTZVVEJNT0RWc1NqSmhSRFl4V0c4dlppc3hTSEJNVjI5NE1FZEtjblpzYlZaTGVrNWFPRDA9IiwiY2xpZW50bmFtZSI6ImF6RXZOU3Q0VG1aSk1rTTBSR1V5ZUVKMk1GUkJUakZTWnpsMVNubGhNRUphTlZWdk9HczVlVko2T0QwPSIsInVzZXJpZCI6IlJuUnhhbVI0U1hkUVdrdElja1ZMVWt0eVMyRjBRVDA5In0.Fg5JbggGjDSqu4L3xlD7XofiKCnOon_MlCeRzU1UWQI")
    @GET("getUserAssignedProjects")
    suspend  fun getUserProjectsData( ): UserProjectsPojo

    @Headers("authtoken: eyJ0eXBlIjoiQlMiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzaXRlaWQiOiJkbFZQV0V0aEwzcG1SMkpFUVc1NFpsYzJaREpSWnowOSIsImRldmljZW5vIjoiWm1OQmVtOTZVVEJNT0RWc1NqSmhSRFl4V0c4dlppc3hTSEJNVjI5NE1FZEtjblpzYlZaTGVrNWFPRDA9IiwiY2xpZW50bmFtZSI6ImF6RXZOU3Q0VG1aSk1rTTBSR1V5ZUVKMk1GUkJUakZTWnpsMVNubGhNRUphTlZWdk9HczVlVko2T0QwPSIsInVzZXJpZCI6IlJuUnhhbVI0U1hkUVdrdElja1ZMVWt0eVMyRjBRVDA5In0.Fg5JbggGjDSqu4L3xlD7XofiKCnOon_MlCeRzU1UWQI")
    @GET("ddoctemplate/2854")
    suspend  fun getUserTempleteProjectsData(@Query("pageno") pageno:String,
                                             @Query("docid") docid:String,
                                             @Query("issue_id") issue_id:String,
                                             @Query("pid") pid:String,
                                             @Query("recurrence") recurrence:String,
                                             @Query("clone") clone:String,
    ): ProjectTempletePojo
    /*
    * pageno,docid,issue_id,pid,recurrence,clone
     pageno:String,docid:String,issue_id:String,pid:String,recurrence:String,clone:String*/
}