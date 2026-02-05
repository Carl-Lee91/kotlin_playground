package com.example.carlexample.feat.auth.data.repository


import com.example.carlexample.core.common.Result
import com.example.carlexample.feat.auth.data.source.LoginResponseParser
import com.example.carlexample.feat.auth.domain.entity.UserEntity
import com.example.carlexample.feat.auth.domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class LoginRepositoryImpl(private val responseParser: LoginResponseParser) : LoginRepository {

    companion object{
        private const val LOGIN_URL = "https://example.com/login"

    }

    override suspend fun makeLoginRequest(jsonBody: String): Result<UserEntity> =
        withContext(Dispatchers.IO){
            try {
                val url = URL(LOGIN_URL)
                (url.openConnection() as? HttpURLConnection)?.run {
                    requestMethod = "POST"
                    setRequestProperty("Content-Type", "application/json; utf-8")
                    doOutput = true
                    outputStream.write(jsonBody.toByteArray())

                    val response = responseParser.parse(inputStream)

                    Result.Success(UserEntity(id = response.userId, name = response.nickName))
                } ?:Result.Error(Exception("연결 실패"))
            } catch (e: Exception){
                Result.Error(e)
            }
        }

}