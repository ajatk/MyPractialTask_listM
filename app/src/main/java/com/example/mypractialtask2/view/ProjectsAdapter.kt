package com.example.mypractialtask2.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mypractialtask2.R
import com.example.mypractialtask2.commons.constants.ConstantValues.Companion.baseUrl
import com.example.mypractialtask2.databinding.LayoutProjectsRowBinding
import com.example.mypractialtask2.view.ProjectsAdapter.*
import com.example.mypractialtask2.view.models.UserProject

class ProjectsAdapter(requireContext: Context) : RecyclerView.Adapter<ProjectsAdapterViewHolder>() {
     private var userProjects: List<UserProject>?=null
    inner class ProjectsAdapterViewHolder(val binding: LayoutProjectsRowBinding) :RecyclerView.ViewHolder(binding.root) {

    }
      fun updateList(userProjects: List<UserProject>) {
          this.userProjects =userProjects

      }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsAdapterViewHolder {
    val view: LayoutProjectsRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.layout_projects_row, parent,false)
        return ProjectsAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectsAdapterViewHolder, position: Int) {
        with(holder.binding){
            userProjects!![position].let {
              /*  ivUser.load(baseUrl+it.image?:""){
                    placeholder(R.drawable.ic_launcher_background)
                }*/
                tvTitle.text = it.title?:""
                tvEmail.text = it.username?:""
            }

        }
    }

    override fun getItemCount(): Int {
         return userProjects?.size?:0
    }
}