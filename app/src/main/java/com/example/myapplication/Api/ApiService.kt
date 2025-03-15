package com.example.myapplication.Api

import com.example.myapplication.data.Post
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPost(): List<Post>
}