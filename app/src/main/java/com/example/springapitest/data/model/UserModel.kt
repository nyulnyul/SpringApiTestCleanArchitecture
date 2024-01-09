package com.example.springapitest.data.model

//server -> client
data class UserModel(
    val id: Long,
    val name: String,
    val email: String,
    val password: String
) {

}