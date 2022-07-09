package com.example.retrofitapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService  {
    @GET
    suspend fun getRetrofitappByBreeds(@Url url:String):Response<RetrofitappResponse>
}
// este interfaz crea el metodo por el cual accedemos a nuestro api