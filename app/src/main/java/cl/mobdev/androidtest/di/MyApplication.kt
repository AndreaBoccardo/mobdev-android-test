package cl.mobdev.androidtest.di

import android.app.Application
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

internal class MyApplication : Application() {
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
