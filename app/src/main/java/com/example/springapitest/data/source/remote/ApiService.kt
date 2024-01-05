package com.example.springapitest.data.source.remote

import com.example.springapitest.data.model.UserModel
import com.example.springapitest.data.repository.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("users/register")
    suspend fun registerUser(
        @Body user: User
    ): Response<UserModel>
}