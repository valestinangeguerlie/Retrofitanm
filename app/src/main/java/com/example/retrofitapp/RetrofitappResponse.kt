package com.example.retrofitapp

import com.google.gson.annotations.SerializedName


data class RetrofitappResponse(
    @SerializedName("status") var status:String,
    @SerializedName("message") var images:List<String>
)