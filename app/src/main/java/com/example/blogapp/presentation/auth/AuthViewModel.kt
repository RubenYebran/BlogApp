package com.example.blogapp.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.blogapp.core.Result
import com.example.blogapp.domain.auth.AuthRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class AuthViewModel(private val repo: AuthRepo) : ViewModel() {

    fun signIn(email: String, password: String) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.signIn(email, password)))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    fun signUp(email: String, password: String, username:  String) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.signIn(email, password, username)))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }


}

