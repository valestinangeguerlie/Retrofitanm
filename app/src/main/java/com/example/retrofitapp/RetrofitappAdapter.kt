package com.example.retrofitapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RetrofitappAdapter(val images:List<String>):RecyclerView.Adapter<RetrofitappViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitappViewHolder {
         val layoutInflater = LayoutInflater.from(parent.context)
         return RetrofitappViewHolder(layoutInflater.inflate(R.layout.item_retrofitapp ,parent, false))
    }

    override fun onBindViewHolder(holder: RetrofitappViewHolder, position: Int) {
        val item:String = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = images.size
    }
}