package com.example.mypractialtask2.view.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.create

@InstallIn(ViewModelComponent::class)
@Module
object MainModule {

@Provides
fun providesApiInterFace(retrofit:Retrofit):ApiInterFace{
    return retrofit.create(ApiInterFace::class.java)
}
    @Provides
    fun providesProjectsRepository(apiInterFace: ApiInterFace): ProjectsRepository{
        return ProjectsRepository(apiInterFace)
    }
}