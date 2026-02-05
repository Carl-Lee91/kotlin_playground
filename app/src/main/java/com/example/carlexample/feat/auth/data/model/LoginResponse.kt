package com.example.carlexample.feat.auth.data.model

data class LoginResponse(
    val userId: String,
    val token: String,
    val nickName: String,
)