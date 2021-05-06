package com.example.blogapp.domain

import com.example.blogapp.core.Resource
import com.example.blogapp.data.model.Post

class HomeScreenRepoImpl:HomeScreenRepo {
    override suspend fun getLatestPost(): Resource<List<Post>> {
        TODO("Not yet implemented")
    }

}