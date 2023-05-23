package com.example.inflearn_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inflearn_retrofit.adapter.PostAdapter
import com.example.inflearn_retrofit.api.PostApi
import com.example.inflearn_retrofit.api.RetrofitInstance
import com.example.inflearn_retrofit.databinding.ActivityMainBinding
import com.example.inflearn_retrofit.model.Post
import com.example.inflearn_retrofit.model.PostItem
import com.example.inflearn_retrofit.viewModel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel : MainActivityViewModel by viewModels()

        viewModel.getPosts()

        val rvPost = binding.rvPost


        viewModel.posts.observe(this, Observer {posts ->
            val postAdapter = PostAdapter(posts as Post)
            rvPost.adapter = postAdapter
            rvPost.layoutManager = LinearLayoutManager(this)
        })

    }
}