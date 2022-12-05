package com.example.mypractialtask2.view2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractialtask2.MainActivity2.Companion.arrayListB
import com.example.mypractialtask2.R
import com.example.mypractialtask2.view2.adapter.FragBAdapterB


class FragmentB : Fragment() {
    var fragBAdapter : FragBAdapterB?=null
    var recyclerA: RecyclerView? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_b, container, false)
        recyclerA = view.findViewById(R.id.fragB_recycler)
        recyclerA!!.setLayoutManager(LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, true))
        recyclerA!!.setHasFixedSize(true);
        frag_AData()
        return view
    }
    private fun frag_AData() {

        if(!arrayListB.isNullOrEmpty()){
            fragBAdapter = FragBAdapterB(requireActivity(), arrayListB, this)
        }
        recyclerA!!.adapter = fragBAdapter
        //frag_AData()
    }

}
