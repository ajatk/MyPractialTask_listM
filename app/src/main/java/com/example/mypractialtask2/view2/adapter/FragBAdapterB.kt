package com.example.mypractialtask2.view2.adapter

import android.content.Context
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractialtask2.MainActivity2.Companion.arrayList
import com.example.mypractialtask2.MainActivity2.Companion.arrayListB
import com.example.mypractialtask2.R
import com.example.mypractialtask2.view2.fragment.FragmentB

class FragBAdapterB(
    var context: Context,
    var arrayList1: ArrayList<Int>,
    fragmentA: FragmentB
) : RecyclerView.Adapter<FragBAdapterB.MyViewHolder>() {
    internal var itemStateArray = SparseBooleanArray()
    private var listSelected = java.util.ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.sub_frag_a_layout, parent, false)
        return MyViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (!itemStateArray.get(position, false)) {
            holder.radioBtn!!.setChecked(false)
        }else{
            holder.radioBtn!!.setChecked(true)
        }
        arrayListB?.sortBy { it }
         holder._tital!!.setText(arrayListB.get(position).toString())
        holder.radioBtn!!.setOnClickListener(View.OnClickListener {
            var  adapterPosition = position
            if (!itemStateArray.get(adapterPosition, false))
            {
                holder.radioBtn!!.setChecked(true)
                itemStateArray.put(adapterPosition, true)
               // arrayList!!.add(arrayListB.get(position))


                try {
                    if (!arrayListB.isNullOrEmpty()) {
                        arrayList!!.add(arrayListB.get(position))

                    }
                   /* if(arrayListB.size>1){
                        arrayListB.removeAt(position)
                    } else {
                        arrayListB.clear()
                    }*/
                }catch (e:Exception){
                    e.stackTrace
                    //arrayListB.clear()
                }


                // listSelected.add((serviceData.get(adapterPosition).id).toString())
                println("settt..02 selected.." + adapterPosition + ".." + listSelected+ "....arrayList.." + arrayList
                        + "...arrayListB.." + arrayListB)
            } else {
                holder.radioBtn!!.setChecked(false)
                itemStateArray.put(adapterPosition, false)
               // MainActivity.arrayListB.add(arrayList.get(position))
                try {
                    if (arrayList!!.size > 1) {
                        arrayList!!.removeAt(position)
                    } else {
                        arrayList!!.clear()
                    }
                }catch (e:Exception){
                    e.stackTrace
                }

                println("settt..01 selected.." + adapterPosition + ".." + listSelected)
            }
            // serviceview.service_Id_position(listSelected.toString(), adapterPosition.toString())
        })

    }

    override fun getItemCount(): Int {
        if (arrayListB!=null){
            return arrayListB.size
        }
        else{
            return 0

        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        private val RECOVERY_REQUEST = 1
        var radioBtn: RadioButton? = null
        var _tital : TextView?=null

       // var youTubePlayerView : YouTubePlayerView?=null
        var context : Context?=null
        init {
            _tital=itemView.findViewById(R.id.frag_Atext)
            radioBtn = itemView.findViewById(R.id.radio_btn)
            context = itemView.context


        }




    }
}

