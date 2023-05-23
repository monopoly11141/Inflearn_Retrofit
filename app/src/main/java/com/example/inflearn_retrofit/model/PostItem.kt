package com.example.inflearn_retrofit.model


import com.google.gson.annotations.SerializedName

data class PostItem(
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
)