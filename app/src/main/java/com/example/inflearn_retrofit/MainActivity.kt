package com.example.inflearn_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postApi = RetrofitInstance.getInstance().create(PostApi::class.java)

        postApi.getPosts().enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("MainActivity", "getPosts : ${response.body()}")
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("MainActivity", "failed to get posts in getPosts")
            }

        })

        postApi.getPostNumber(2).enqueue(object : Callback<PostItem> {

            override fun onResponse(call: Call<PostItem>, response: Response<PostItem>) {
                Log.d("MainActivity", "getPostNumber2 : ${response.body()}")
            }

            override fun onFailure(call: Call<PostItem>, t: Throwable) {
                Log.d("MainActivity", "failed to get posts in getPostNumber")
            }

        })
    }
}