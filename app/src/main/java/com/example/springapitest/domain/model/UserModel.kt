package com.example.springapitest.domain.model

//server -> client
data class UserModel(
    val id: Long,
    val name: String,
    val email: String,
    val password: String
) {

}