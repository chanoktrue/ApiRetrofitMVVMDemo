package com.trueddns.homenano.apiretrofitdemo.repository

import com.trueddns.homenano.apiretrofitdemo.api.RetrofitInstance
import com.trueddns.homenano.apiretrofitdemo.model.Post
import retrofit2.Response
import retrofit2.http.POST

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number )
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }

}