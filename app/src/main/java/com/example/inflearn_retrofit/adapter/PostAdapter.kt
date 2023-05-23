package com.example.inflearn_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.inflearn_retrofit.R
import com.example.inflearn_retrofit.databinding.PostItemBinding
import com.example.inflearn_retrofit.model.Post
import com.example.inflearn_retrofit.model.PostItem

class PostAdapter(private val post : Post) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var binding : PostItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.post_item, parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return post.size
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
       holder.bind(post[position])
    }

    inner class ViewHolder(binding : PostItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(postItem : PostItem) {
            binding.tvTitle.text = postItem.title
            binding.tvBody.text = postItem.body
        }
    }
}