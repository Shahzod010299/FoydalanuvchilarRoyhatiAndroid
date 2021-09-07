package com.example.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.UserData
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.ArrayList

class UserAdpater(val data: ArrayList<UserData>): RecyclerView.Adapter<UserAdpater.ViewHolder>(){

    private var listiner: ((Int) -> Unit)? = null

    data class ViewHolder(val view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            data[position].avatar?.let { my_image?.setImageResource(it) }
            my_user_text?.text = data[position].name
            my_user_text_number?.text = data[position].numbers
        }
        holder.itemView.delete_image.setOnClickListener {
            Log.d("myTAG",position.toString())
            listiner?.invoke(position)
        }
    }

    override fun getItemCount() = data.size

    fun  setOnItemClickListiner(f: (Int)-> Unit){
        listiner = f
    }

}