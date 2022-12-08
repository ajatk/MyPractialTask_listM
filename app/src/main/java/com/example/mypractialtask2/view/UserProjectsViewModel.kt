package com.example.mypractialtask2.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypractialtask2.commons.utillss.ErrorResponse
import com.example.mypractialtask2.commons.utillss.ResultWrapper
import com.example.mypractialtask2.view.di.ProjectsRepository
import com.example.mypractialtask2.view.models.ProjectTempletePojo
import com.example.mypractialtask2.view.models.UserProjectsPojo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProjectsViewModel @Inject constructor(val repository: ProjectsRepository) : ViewModel(){

    private var liveDataProjectData1 = MutableLiveData<ResultWrapper<UserProjectsPojo>>()
    fun androidGetPojectData1( ) : MutableLiveData<ResultWrapper<UserProjectsPojo>> {
        viewModelScope.launch (Dispatchers.IO){
            liveDataProjectData1.postValue(ResultWrapper.Loading)
            try {
                val responsee = repository.projectsData1()
                liveDataProjectData1.postValue(ResultWrapper.Success(responsee))
            }catch (e:Exception){
                e.printStackTrace()
                liveDataProjectData1.postValue(ResultWrapper.GenericError(
                    ErrorResponse(-1, e.message)
                ))

            }
        }
        return liveDataProjectData1
    }


    private var liveDataTempletProject  = MutableLiveData<ResultWrapper<ProjectTempletePojo>>()
    fun androidGetTempletePoject( pageno:String,docid:String,issue_id:String,pid:String,recurrence:String,clone:String) : MutableLiveData<ResultWrapper<ProjectTempletePojo>> {
        viewModelScope.launch (Dispatchers.IO){
            liveDataTempletProject.postValue(ResultWrapper.Loading)
            try {
                val responsee = repository.projectsTempleteData1(pageno,docid,issue_id,pid,recurrence,clone)
                liveDataTempletProject.postValue(ResultWrapper.Success(responsee))
            }catch (e:Exception){
                e.printStackTrace()
                liveDataTempletProject.postValue(ResultWrapper.GenericError(
                    ErrorResponse(-1, e.message)
                ))

            }
        }
        return liveDataTempletProject
    }
}