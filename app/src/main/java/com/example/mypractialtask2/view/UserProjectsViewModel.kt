package com.example.mypractialtask2.view

import androidx.lifecycle.ViewModel
import com.example.mypractialtask2.view.di.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProjectsViewModel @Inject constructor(val repository: ProjectsRepository) : ViewModel(){
}