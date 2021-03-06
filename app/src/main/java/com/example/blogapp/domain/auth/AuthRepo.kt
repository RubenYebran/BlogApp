package com.example.blogapp.domain.auth

import android.graphics.Bitmap
import com.google.firebase.auth.FirebaseUser

interface AuthRepo {
    suspend fun signIn(email: String, password: String): FirebaseUser?
    suspend fun signIn(email: String, password: String, username: String): FirebaseUser?
    suspend fun updateProfile(imageBitMap: Bitmap, username: String)
}