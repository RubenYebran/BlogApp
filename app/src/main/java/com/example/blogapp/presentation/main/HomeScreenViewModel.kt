package com.example.blogapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.blogapp.core.Resource
import com.example.blogapp.domain.home.HomeScreenRepo
import kotlinx.coroutines.Dispatchers

class HomeScreenViewModel(private val repo: HomeScreenRepo) : ViewModel() {
    fun fetchLatestPost() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getLatestPost())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}