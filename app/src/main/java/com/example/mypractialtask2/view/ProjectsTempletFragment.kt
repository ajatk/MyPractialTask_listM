package com.example.mypractialtask2.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.mypractialtask2.R
import com.example.mypractialtask2.commons.utillss.ResultWrapper
import com.example.mypractialtask2.databinding.FragmentTempleteProjectsBinding
import com.example.mypractialtask2.view.models.DataHeader
import com.example.mypractialtask2.view.models.ProjectTempletePojo
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProjectsTempletFragment : Fragment() {
    private val viewModel: UserProjectsViewModel by viewModels()
    private var viewBinding :FragmentTempleteProjectsBinding?=null
    var params: LinearLayout.LayoutParams? = null
    var layoutMain: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_user_projects, container, false)
        viewBinding = FragmentTempleteProjectsBinding.inflate(layoutInflater)
        val view = viewBinding!!.root
        albumApi()
        return view
    }

    private fun addView(dataHeader: DataHeader) {
//        var str:String = "https%3A%2F%2Fdevelopment-mobile.builderstorm.com%2F%2Fuploads%2Fdevelopment-mobile%2Fcustom_documents%2Fheader_608a8a0318c37.jpg"
//        str= str.replace("%3A",":").replace("%2F","/")
        //var url1 = URLEncoder.encode(str, "UTF-8")
       // with(dataHeader){
            layoutMain = LinearLayout(requireContext())
        layoutMain?.orientation  =LinearLayout.VERTICAL
        layoutMain?.layoutParams = addLinearMatchedParamm()
        layoutMain?.addView(addImage(R.drawable.logo_builder_storm, 55, 70, dataHeader,"header").apply {
            setPadding(0,10,0,10)
        },addImageParamm())
        layoutMain?.addView(createTextView("Name"),params)
        layoutMain?.addView(createEditText("",70,true),params)
        layoutMain?.addView(createTextView("Id number"),params)
        layoutMain?.addView(createEditText("",70,true),params)
        layoutMain?.addView(createTextView("Remarks"),params)
        layoutMain?.addView(createEditText("",150,false),params)
        layoutMain?.addView(addButton("Add from BuilderStorm",R.drawable.ic_upload_24),params)

        layoutMain?.addView(addImage(R.drawable.logo_builder_storm, 55, 60, dataHeader,"footer").apply {
            setPadding(0,10,0,10)
        },params)
        layoutMain?.addView(buttonHorizontalView(),params)
        viewBinding?.llmain?.addView(layoutMain)

    }

    private fun albumApi() {
        viewModel.androidGetTempletePoject(
            pageno="0",docid="0",issue_id="",pid="${arguments?.getString("uid")}",recurrence="",clone="0"
        ).observe(viewLifecycleOwner,{
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
                    is ProjectTempletePojo -> {
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

    private fun setData(projectsPojo: ProjectTempletePojo) {
        projectsPojo?.dataHeader.let {
            addView(it)
        }

    }
    fun createEditText(hintt: String?, height:Int,b:Boolean):EditText {
        val editText = EditText(requireContext()).apply {
            hint=hintt
            textSize =12f
            isSingleLine =b
            imeOptions=EditorInfo.IME_ACTION_NEXT
            setTextColor(addTextColor())
            setHintTextColor(addTextColor())
            setPadding(12,3,5,3)
            this.height=height
            background =ContextCompat.getDrawable(requireContext(),R.drawable.circular_corner_shape)
        }
        //editText.id = viewsCount++

        return editText
    }
    fun createTextView(hintt: String?):TextView {
        val editText = TextView(requireContext()).apply {
            hint=hintt
            setTextColor(addTextColor())
            setHintTextColor(addTextColor())
        }
        return editText
    }
    private fun addImage(icSave24: Int, height: Int, width: Int, dataHeader: DataHeader, type:String):ImageView{
        val image = ImageView(requireContext()).apply {
            maxHeight = height
            maxWidth = width
            // this.width.=width
            var str="";
            if(type.equals("header"))
                str = dataHeader.let { it.template_header }
            else  str = dataHeader.let { it.template_footer }
                str= str.replace("%3A",":").replace("%2F","/")

            if(!str.isNullOrEmpty())
            if(str.contains(".jpg")||str.contains(".jpeg")||str.contains(".png"))
            load(str){
                placeholder(resources.getDrawable(icSave24))
            }
            else
             setImageDrawable( resources.getDrawable(icSave24))
        }
        return image
    }
    private fun addImage(icSave24: Int, height: Int, width: Int):ImageView{
        val image = ImageView(requireContext()).apply {
            maxHeight = height
            maxWidth = width
             setImageDrawable( resources.getDrawable(icSave24))
        }
        return image
    }
    private fun addButton(name:String, drawable: Int):LinearLayout {
        val layoutBtn = LinearLayout (requireContext()).apply {
            layoutParams=addLinearMatchedParam().apply {
                weight=1.0f
                 setMargins(45, 20, 45, 20)
            }
            gravity=Gravity.CENTER
            orientation = LinearLayout.HORIZONTAL
            setPadding(8,8,8,8)

            addView(addImage(drawable, 55, 60))
            addView(createTextView(name).apply {
                setTextColor( ColorStateList.valueOf(resources.getColor(R.color.white)))
                setHintTextColor( ColorStateList.valueOf(resources.getColor(R.color.white)))
                setPadding(5, 5, 5, 5)
            })
            background =ContextCompat.getDrawable(requireContext(),R.drawable.circular_corner_shape)
         backgroundTintList= ColorStateList.valueOf(resources.getColor(R.color.navicolor_light))
        }
        return layoutBtn
    }
    private fun buttonHorizontalView():LinearLayout {
        val layoutHorizontalView = LinearLayout (requireContext()).apply {
            layoutParams=addLinearMatchedParam()
            gravity=Gravity.CENTER
            orientation = LinearLayout.HORIZONTAL

            addView(addButton("Draft",R.drawable.ic_save_24).apply {
                params?.apply {
                    setMargins(35, 20, 0, 20)
                }
                weightSum =2f
            })
            addView(addButton("Save",R.drawable.ic_save_24).apply {
                params?.apply {
                    setMargins(15, 20, 35, 20)
                    //setPadding(5,8,5,8)
                }
            })
        }
        return layoutHorizontalView
    }

    private fun addLinearMatchedParamm( ):LinearLayout.LayoutParams{
        params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(25, 5, 25, 5)
        }
        return params!!
    }
    private fun addImageParamm( ):LinearLayout.LayoutParams{
       var params = LinearLayout.LayoutParams(
           LinearLayout.LayoutParams.MATCH_PARENT,  300
        ).apply {
           // setMargins(25, 5, 25, 5)
            gravity=Gravity.CENTER
        }
        return params
    }
    private fun addLinearMatchedParam():LinearLayout.LayoutParams{
        params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity=Gravity.CENTER
        }
        return params!!
    }
    private fun addTextColor():ColorStateList{
        return ColorStateList.valueOf(Color.BLACK)
    }

}