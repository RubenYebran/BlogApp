package com.example.blogapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.blogapp.core.Result
import com.example.blogapp.domain.home.HomeScreenRepo
import kotlinx.coroutines.Dispatchers

class HomeScreenViewModel(private val repo: HomeScreenRepo) : ViewModel() {
    fun fetchLatestPost() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getLatestPost())
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}