package cl.mobdev.androidtest.ui.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.mobdev.androidtest.R
import cl.mobdev.androidtest.presentation.LoginViewModel

@Composable
fun ValidationComponent(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    val email by remember { mutableStateOf(TextFieldValue("")) }
    val password by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .padding(top = 30.dp)
            .padding(start = 125.dp)
            .background(Color.White)
    ) {
        ThirdButtonMedium(
            text = stringResource(id = R.string.start_session),
            email.text.length > 2 &&
                    password.text.length > 2
        ) {
            loginViewModel.onLoginSelected(
                email = email.text,
                password = password.text,
                navController = navController,
                trimmedEmail = ""
            )
        }
    }
}
