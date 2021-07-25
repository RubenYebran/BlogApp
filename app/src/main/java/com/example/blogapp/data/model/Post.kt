package com.example.blogapp.data.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("profile_picture")
    val profile_picture: String = "",
    @SerializedName("profile_name")
    val profile_name: String = "",
    @SerializedName("created_at")
    val created_at: Timestamp? = null,
    @SerializedName("post_image")
    val post_image: String = "",
    @SerializedName("postDescription")
    val post_description: String = "",
    @SerializedName("uid")
    val uid: String = ""
)