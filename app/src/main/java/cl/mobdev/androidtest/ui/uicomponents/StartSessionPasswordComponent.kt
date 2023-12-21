package cl.mobdev.androidtest.ui.uicomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cl.mobdev.androidtest.R
import cl.mobdev.androidtest.presentation.LoginViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun StartSessionPasswordComponent(loginViewModel: LoginViewModel) {
    val loginViewState by loginViewModel.viewState.collectAsState()
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val passwordVisible = mutableStateOf(false)
    val visualTransformation = if (passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    Text(
        text = "password",
        Modifier
            .padding(start = 22.dp)
            .padding(top = 10.dp),
        fontWeight = FontWeight.Bold
    )

    TextField(
        value = password,
        onValueChange = {
            password = it
        },
        modifier = Modifier
            .padding(start = 22.dp)
            .padding(end = 22.dp)
            .height((45.dp))
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        placeholder = {}
    )

    if (!loginViewState.isValidPassword) {
        Text(
            text = stringResource(id = R.string.password_valid),
            modifier = Modifier.padding(start = 22.dp)
        )
    }

    if (loginViewState.userNotExist) {
        Text(
            text = stringResource(id = R.string.user_not_exist),
            modifier = Modifier.padding(start = 22.dp)
        )
    }
}
