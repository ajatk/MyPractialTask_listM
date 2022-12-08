package com.example.mypractialtask2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mypractialtask2.commons.utillss.ResultWrapper
import com.example.mypractialtask2.databinding.FragmentUserProjectsBinding
import com.example.mypractialtask2.view.models.UserProjectsPojo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProjectsFragment : Fragment() {
    private val viewModel: UserProjectsViewModel by viewModels()

    private var viewBinding :FragmentUserProjectsBinding?=null
    private var userProjectsPojo: UserProjectsPojo?=null
    private val projectsAdapter by lazy {
        ProjectsAdapter(requireContext(), )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_user_projects, container, false)
          viewBinding= FragmentUserProjectsBinding.inflate(layoutInflater)
        val view = viewBinding!!.root
        with(viewBinding!!){
            rvUserProjects.adapter = projectsAdapter
            albumApi()
        }
        return view
    }
    private fun albumApi() {
        viewModel.androidGetPojectData1( ).observe(viewLifecycleOwner,{
            updateUI(it)
        })
    }
    private fun updateUI(_state: ResultWrapper<Any>?) {
        when (_state) {
            is ResultWrapper.Loading -> {
                viewBinding!!.progressBarB.visibility = View.VISIBLE
            }
            is ResultWrapper.NetworkError -> {
                viewBinding!!.progressBarB.visibility = View.GONE
            }
            is ResultWrapper.GenericError -> {
                viewBinding!!.progressBarB.visibility = View.GONE
                _state.error?.error?.let {
                    Toast.makeText(requireContext(), "err " + it, Toast.LENGTH_SHORT).show()
                }
            }
            is ResultWrapper.Success -> {
                when (_state.data) {
                    is UserProjectsPojo -> {
                        _state.data.let {
                            setData(it)
                        }
                        // Toast.makeText(requireActivity(), "${_state.data.message} ", Toast.LENGTH_LONG).show()
                    }

                }
                viewBinding!!.progressBarB.visibility = View.GONE
            }
        }
    }

    private fun setData(userProjectsPojo: UserProjectsPojo) {
        userProjectsPojo?.data.user_projects.let {
            projectsAdapter.updateList(it)
            projectsAdapter.notifyDataSetChanged()
        }

    }

}