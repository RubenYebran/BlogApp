package com.example.blogapp.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("username")
    val username: String = "",
    @SerializedName("photo_url")
    val photo_url: String = ""
)