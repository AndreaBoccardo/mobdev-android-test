package cl.mobdev.androidtest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import cl.mobdev.androidtest.navigation.AppScreens
import cl.mobdev.androidtest.presentation.LoginViewModel
import cl.mobdev.androidtest.ui.uicomponents.ForgetPasswordComponent
import cl.mobdev.androidtest.ui.uicomponents.StartSessionButtonBack
import cl.mobdev.androidtest.ui.uicomponents.StartSessionEmailComponent
import cl.mobdev.androidtest.ui.uicomponents.StartSessionPasswordComponent
import cl.mobdev.androidtest.ui.uicomponents.TitleStartSession
import cl.mobdev.androidtest.ui.uicomponents.ValidationComponent

@Composable
fun StartSession(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    val navigateLoginUser by loginViewModel.navigateToDetails.collectAsState()
    var navigate by remember { mutableStateOf(false) }


    if (navigateLoginUser && !navigate) {
        navController.navigate(AppScreens.OnBoardingPaymentsReceipts.route)
        navigate = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        StartSessionButtonBack(navController = navController)
        TitleStartSession()
        StartSessionEmailComponent(loginViewModel = loginViewModel)
        StartSessionPasswordComponent(loginViewModel = loginViewModel)
        ValidationComponent(loginViewModel = loginViewModel, navController = navController)
        ForgetPasswordComponent(onClick = {})
    }
}
