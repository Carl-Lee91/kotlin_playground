import com.example.carlexample.core.common.Result
import com.example.carlexample.feat.auth.domain.entity.UserEntity
import com.example.carlexample.feat.auth.domain.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {
    suspend operator fun invoke(id: String,pw:String): Result<UserEntity>{
        val jsonBody = """{"id": "$id", "password":"$pw"}"""
        return repository.makeLoginRequest(jsonBody)
    }
}