import ads_mobile_sdk.h5
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel){
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    val status by viewModel.loginState

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "로그인 상태: $status", style = MaterialTheme.typography.labelLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = id, onValueChange = { id = it}, label = {Text("아이디")})
        TextField(value = pw, onValueChange = {pw=it},label = { Text("비밀번호") }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {viewModel.login(id,pw)}) {
            Text("로그인 하기")
        }
    }
}