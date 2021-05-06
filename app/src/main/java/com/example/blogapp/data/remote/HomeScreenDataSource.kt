package com.example.blogapp.data.remote

import com.example.blogapp.core.Resource
import com.example.blogapp.data.model.Post
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {

    suspend fun getLatestPosts(): Resource<List<Post>>{
        val postList = mutableListOf<Post>()

        val querySnatpshot = FirebaseFirestore.getInstance().collection("posts").get().await() //Almacenamos los valores de la Query.

        for (documentPost in querySnatpshot.documents){ //Recorremos los documentos "post" dentro de la variable querySnapshot (con .documents)
            documentPost.toObject(Post::class.java)?.let { post -> //Convertimos cada documento "post" a un verdadero objeto post. (Utilizando nuestro modelo)
                postList.add(post) //Agregamos cada uno de los posts a nuestra list de posts.
            }
        }
        return Resource.Success(postList)
    }
}