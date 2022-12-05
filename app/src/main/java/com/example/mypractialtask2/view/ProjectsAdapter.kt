package com.example.mypractialtask2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractialtask2.R
import com.example.mypractialtask2.databinding.LayoutProjectsRowBinding
import com.example.mypractialtask2.view.ProjectsAdapter.*

class ProjectsAdapter : RecyclerView.Adapter<ProjectsAdapterViewHolder>() {
    inner class ProjectsAdapterViewHolder(val binding: LayoutProjectsRowBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsAdapterViewHolder {
    val view: LayoutProjectsRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.layout_projects_row, parent,false)
        return ProjectsAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectsAdapterViewHolder, position: Int) {
        with(holder.binding){

        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}