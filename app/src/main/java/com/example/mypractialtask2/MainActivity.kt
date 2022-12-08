package com.example.mypractialtask2

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import coil.load
import com.example.mypractialtask2.view.ProjectsTempletFragment
import com.example.mypractialtask2.view.UserProjectsFragment
import dagger.hilt.android.AndroidEntryPoint
import java.net.URI
import java.net.URL
import java.net.URLEncoder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFrag(UserProjectsFragment())
        findViewById<AppCompatTextView>(R.id.addTemplete).visibility =View.GONE
//        findViewById<AppCompatTextView>(R.id.addTemplete).setOnClickListener {
//            replaceFrag(ProjectsTempletFragment())
//        }

    }


   public fun replaceFrag(frag:Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_main, frag)
        //fragment.arguments = bundle
        ft.addToBackStack(null)
        ft.commit()

    }


}