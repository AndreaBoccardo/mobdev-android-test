package cl.mobdev.androidtest.ui.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.mobdev.androidtest.R

@Composable
fun StartSessionButtonBack(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.left),
        contentDescription = stringResource(id = R.string.button_back),
        modifier = Modifier
            .padding(start = 22.dp)
            .padding(top = 30.dp)
            .clickable { navController.popBackStack() }
    )
}
