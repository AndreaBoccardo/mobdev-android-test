package cl.mobdev.androidtest

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.mobdev.androidtest.di.MyApplication
import cl.mobdev.androidtest.navigation.AppNavigation
import cl.mobdev.androidtest.presentation.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class MainActivity : ComponentActivity() {
    @Inject
    internal lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        injectDependencies()

        setContent {
            AppNavigation()
        }
    }

    private fun injectDependencies() {
        (application as MyApplication).appComponent.inject(this)
    }
}
