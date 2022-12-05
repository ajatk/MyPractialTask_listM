package com.example.mypractialtask2.view2.adapter

import android.content.Context
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractialtask2.MainActivity2.Companion.arrayList
import com.example.mypractialtask2.MainActivity2.Companion.arrayListB
import com.example.mypractialtask2.R
import com.example.mypractialtask2.view2.ServiceRequestView

class FragAAdapterA(
    var context: Context,
    var arrayList1: ArrayList<Int>,
    serviceRequestView: ServiceRequestView
) : RecyclerView.Adapter<FragAAdapterA.MyViewHolder>() {
    internal var itemStateArray = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemLayoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.sub_frag_a_layout, parent, false)
        return MyViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (!itemStateArray.get(position, false)) {
            holder.radioBtn!!.setChecked(false)
        } else {
            holder.radioBtn!!.setChecked(true)
        }
        arrayList?.sortBy { it }
        holder._tital!!.setText(arrayList!!.get(position).toString())
        holder.radioBtn!!.setOnClickListener(View.OnClickListener {
            var adapterPosition = position
            if (!itemStateArray.get(adapterPosition, false)) {
                holder.radioBtn!!.setChecked(true)
                itemStateArray.put(adapterPosition, true)

                try {
                    if (arrayList!= null) {
                        arrayListB.add(arrayList!!.get(position))

                    }
                   /* if (arrayList!!.size > 1) {
                        arrayList!!.removeAt(position)
                    } else {
                        arrayList!!.clear()
                    }*/
                }catch (e:Exception){
                    e.stackTrace
                   // arrayList!!.clear()
                }


                println("settt..02 selected.AAAA.." + adapterPosition + "...arrayListB.." +arrayListB
                        + "..arrayList..." +arrayList)
            } else {
                holder.radioBtn!!.setChecked(false)
                itemStateArray.put(adapterPosition, false)
                try {
                    if(arrayListB.size>1){
                        arrayListB.removeAt(position)
                    } else {
                        arrayListB.clear()
                    }
                }catch (e:Exception){
                    e.stackTrace
                }

                println("settt..01 selected.AAAA.." + adapterPosition + "...arrayListB.." +arrayListB
                        + "..arrayList..." +arrayList)
            }
            // serviceview.service_Id_position(listSelected.toString(), adapterPosition.toString())
        })

    }

    override fun getItemCount(): Int {
        if (arrayList != null) {
            return arrayList!!.size
        } else {
            return 0
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val RECOVERY_REQUEST = 1

        var _tital: TextView? = null
        var radioBtn: RadioButton? = null
        // var youTubePlayerView : YouTubePlayerView?=null
        var context: Context? = null

        init {
            _tital = itemView.findViewById(R.id.frag_Atext)
            radioBtn = itemView.findViewById(R.id.radio_btn)
            context = itemView.context


        }


    }
}

