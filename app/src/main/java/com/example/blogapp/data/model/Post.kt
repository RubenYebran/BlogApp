package com.example.blogapp.data.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("author")
    val profile_picture: String = "",
    @SerializedName("author")
    val profile_name: String = "",
    @SerializedName("author")
    val post_timestamp: Timestamp? = null,
    @SerializedName("author")
    val post_image: String = "",
    @SerializedName("postDescription")
    val post_description: String = "",
    @SerializedName("uid")
    val uid: String = ""
)