package com.example.blogapp.data.remote.home

import com.example.blogapp.core.Result
import com.example.blogapp.data.model.Post
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {

    suspend fun getLatestPosts(): Result<List<Post>> {

        val postList = mutableListOf<Post>()

        val querySnatpshot = FirebaseFirestore.getInstance().collection("posts").get().await() //Almacenamos los valores de la Query.

        for (post in querySnatpshot.documents){ //Recorremos los documentos "post" dentro de la variable querySnapshot (con .documents)
            post.toObject(Post::class.java)?.let { fbpost -> //Convertimos cada documento "post" a un verdadero objeto post. (Utilizando nuestro modelo)

                fbpost.apply {
                    created_at = post.getTimestamp("created_at",DocumentSnapshot.ServerTimestampBehavior.ESTIMATE)?.toDate()
                }
                postList.add(fbpost) //Agregamos cada uno de los posts a nuestra list de posts.
            }
        }
        return Result.Success(postList)
    }
}