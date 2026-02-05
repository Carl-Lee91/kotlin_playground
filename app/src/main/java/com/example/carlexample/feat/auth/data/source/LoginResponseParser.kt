package com.example.carlexample.feat.auth.data.source

import com.example.carlexample.feat.auth.data.model.LoginResponse
import java.io.InputStream

class LoginResponseParser {
    fun parse(inputStream: InputStream): LoginResponse {
        return LoginResponse("user_123", "token_abc", "코딩파트너")
    }
}