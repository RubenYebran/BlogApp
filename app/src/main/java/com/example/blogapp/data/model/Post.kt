package com.example.blogapp.data.model

import com.google.firebase.firestore.ServerTimestamp
import com.google.gson.annotations.SerializedName
import java.util.*

data class Post(
    @SerializedName("profile_picture")
    val profile_picture: String = "",
    @SerializedName("profile_name")
    val profile_name: String = "",
    @ServerTimestamp
    @SerializedName("created_at")
    var created_at: Date? = null,
    @SerializedName("post_image")
    val post_image: String = "",
    @SerializedName("postDescription")
    val post_description: String = "",
    @SerializedName("uid")
    val uid: String = ""
)