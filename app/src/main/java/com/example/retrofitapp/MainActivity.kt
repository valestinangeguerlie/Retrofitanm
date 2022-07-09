package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Query

class MainActivity : AppCompatActivity(),  SearchView.OnQueryTextListener{

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: RetrofitappAdapter
    private val retrofitImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svRetrofitApp.setOnQueryTextListener(this)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = RetrofitappAdapter(retrofitImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
             .build()
    }

    private fun searchByName(query: String){
        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit()
                .create(ApiService::class.java).getRetrofitappByBreeds("$query/images")
            val puppies : RetrofitappResponse? = call.body()
            runOnUiThread{
                if (call.isSuccessful){
                    val images:List<String> = puppies?.images?: emptyList()
                    retrofitImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else {
                    //show error
            }
            hidekeyboard()

            }


            }
        }

    private fun hidekeyboard() {

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            searchByName(query.toLowerCase())
        }
        return true

    }

    override fun onQueryTextChange(newText: String?): Boolean {
       return true
    }


    private fun showError() {
      Toast.makeText(this,"ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }


}