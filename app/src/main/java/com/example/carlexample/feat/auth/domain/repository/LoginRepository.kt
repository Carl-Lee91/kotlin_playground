package com.example.carlexample.feat.auth.domain.repository

import com.example.carlexample.core.common.Result
import com.example.carlexample.feat.auth.domain.entity.UserEntity

interface LoginRepository {
   suspend fun makeLoginRequest(jsonBody: String): Result<UserEntity>
}