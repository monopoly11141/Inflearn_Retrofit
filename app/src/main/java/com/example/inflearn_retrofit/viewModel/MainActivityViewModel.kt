package com.example.inflearn_retrofit.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inflearn_retrofit.api.PostApi
import com.example.inflearn_retrofit.api.RetrofitInstance
import com.example.inflearn_retrofit.model.Post
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val TAG = this.javaClass.simpleName

    private var _postTitle = MutableLiveData("")
    val postTitle : LiveData<String>
        get() = _postTitle

    private var _postBody = MutableLiveData("")
    val postBody : LiveData<String>
        get() = _postBody

    private var _posts = MutableLiveData<Post>()
    val posts : LiveData<Post>
        get() = _posts

    private val retrofitInstance = RetrofitInstance.getInstance().create(PostApi::class.java)

    fun getPosts() = viewModelScope.launch{
        val post = retrofitInstance.getPosts()
        _posts.value = post
    }

    fun getPostNumber(number : Int) = viewModelScope.launch{
        val post = retrofitInstance.getPostNumber(number)

        _postTitle.value = post.title
        _postBody.value = post.body
    }

}