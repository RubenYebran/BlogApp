package com.example.blogapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.blogapp.core.Resource
import com.example.blogapp.domain.HomeScreenRepo
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