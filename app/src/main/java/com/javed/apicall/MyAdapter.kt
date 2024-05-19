package com.javed.apicall

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(private val userList: List<Model>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val emailTextView: TextView = itemView.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.singlerow, parent, false) // item_layout is the XML layout you provided
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        val user = userList[position]
        holder.nameTextView.text = "Name: ${user.name}"
        holder.emailTextView.text = "Email: ${user.email}"
    }

    override fun getItemCount(): Int  {
        return userList.size
    }


}