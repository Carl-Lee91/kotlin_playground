import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carlexample.core.common.Result
import kotlinx.coroutines.launch


class LoginViewModel(private val loginUseCase: LoginUseCase): ViewModel() {
    var loginState = mutableStateOf<String>("대기 중")
        private set

    fun login(id: String, pw:String){
        viewModelScope.launch {
            loginState.value = "로딩 중"
            var result = loginUseCase(id,pw)
            loginState.value =when(result){
                is Result.Success -> "성공: ${result.data.name}"
                is Result.Error -> "실패: ${result.exception.message}"
            }
        }
    }
}