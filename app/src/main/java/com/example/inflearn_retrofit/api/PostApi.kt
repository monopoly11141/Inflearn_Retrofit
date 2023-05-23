package com.example.inflearn_retrofit.api

import com.example.inflearn_retrofit.model.Post
import com.example.inflearn_retrofit.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("/posts")
    suspend fun getPosts() : Post

    @GET("/posts/{number}")
    suspend fun getPostNumber(@Path("number") number : Int) : PostItem

}