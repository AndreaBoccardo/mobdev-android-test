package cl.mobdev.androidtest.ui.uicomponents

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import cl.mobdev.androidtest.R
import cl.mobdev.androidtest.presentation.LoginViewModel

@Composable
fun StartSessionEmailComponent(loginViewModel: LoginViewModel) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    val loginViewState by loginViewModel.viewState.collectAsState()

    Text(
        text = stringResource(id = R.string.mail),
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 22.dp)
            .padding(top = 50.dp)
    )

    TextField(
        value = email,
        onValueChange = {
            email = it
        },
        modifier = Modifier
            .height((50.dp))
            .padding(start = 22.dp)
            .padding(end = 22.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.Black,
            backgroundColor = Color.White
        ),
        placeholder = {}
    )

    if (!loginViewState.isValidEmail) {
        Text(
            text = stringResource(id = R.string.mail),
            modifier = Modifier.padding(start = 22.dp)
        )
    }
}
