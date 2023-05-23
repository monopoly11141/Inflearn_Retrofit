package com.example.inflearn_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("/posts")
    fun getPosts() : Call<Post>

    @GET("/posts/{number}")
    fun getPostNumber(@Path("number") number : Int) : Call<PostItem>

}