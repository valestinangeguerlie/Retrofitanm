package com.example.retrofitapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.ItemRetrofitappBinding
import com.squareup.picasso.Picasso

class RetrofitappViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemRetrofitappBinding.bind(view)

    fun bind(images:String){
        Picasso.get().load(images).into(binding.ivRetrofit)
    }
}