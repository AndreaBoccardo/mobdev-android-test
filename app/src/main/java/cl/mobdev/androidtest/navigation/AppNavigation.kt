package cl.mobdev.androidtest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.mobdev.androidtest.MainActivity
import cl.mobdev.androidtest.ui.StartSession

@Composable
fun AppNavigation(navHostController: NavHostController = rememberNavController()) {
    val activity = LocalContext.current as? MainActivity
    val loginViewModel = activity?.loginViewModel

    NavHost(navController = navHostController, startDestination = AppScreens.StartSession.route) {
        composable(route = AppScreens.StartSession.route) {
            if (loginViewModel != null) {
                StartSession(
                    loginViewModel = loginViewModel,
                    navController = navHostController,
                    onClick = {})
            }
        }
    }
}
