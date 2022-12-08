package com.example.mypractialtask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.mypractialtask2.view2.fragment.FragmentA
import com.example.mypractialtask2.view2.fragment.FragmentB
import java.net.URLEncoder

class MainActivity2 : AppCompatActivity() {
    companion object{

        var arrayListB= ArrayList<Int>()
        var arrayList: ArrayList<Int>?=null
    }
    var butnRight: Button? =null
    var butnLeft: Button? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var str:String = "https%3A%2F%2Fdevelopment-mobile.builderstorm.com%2F%2Fuploads%2Fdevelopment-mobile%2Fcustom_documents%2Fheader_608a8a0318c37.jpg".replace("%3A",":").replace("%2","")
        //var url = URLEncoder.encode(str)
        Log.e("TAG", "onCreate: sdkhfgkldsfdsf..$str", )

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.a_fragment, FragmentA())
            .replace(R.id.b_fragment, FragmentB()).commit()

        butnRight = findViewById(R.id.btnRight)
        butnLeft = findViewById(R.id.btnLeft)
        frag_AData()
        setonClicked()
    }

    private fun setonClicked() {
        butnRight!!.setOnClickListener {

          for(i in 0 until arrayListB.size){
              try {
                  if(arrayList!!.size>1){
                      arrayList?.remove(arrayListB.get(i))
                  }else{
                      arrayList?.clear()
                  }
              }catch (e:Exception){e.printStackTrace()}


          }


            fragmentReplaced()
        }
        butnLeft!!.setOnClickListener {
            for(i in 0 until arrayListB.size){
                 try {
                     if(arrayListB?.size>1){
                         arrayListB?.remove(arrayListB.get(i))
                     } else {
                         arrayListB?.clear()
                     }
                 }catch (e:Exception){e.printStackTrace()}


            }
            fragmentReplaced()

        }
    }
fun fragmentReplaced(){
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.a_fragment, FragmentA())
        .replace(R.id.b_fragment, FragmentB()).commit()
}
    private fun frag_AData() {
        arrayList =ArrayList<Int>()
        arrayList!!.add(0)
        arrayList!!.add(1)
        arrayList!!.add(2)
        arrayList!!.add(3)
        arrayList!!.add(4)
        arrayList!!.add(5)
        arrayList!!.add(6)
        arrayList!!.add(7)
        arrayList!!.add(8)
        arrayList!!.add(9)




        //recyclerA!!.adapter = fragAAdapter
        //frag_AData()
    }
}