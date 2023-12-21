package cl.mobdev.androidtest.di

import android.content.Context
import cl.mobdev.androidtest.MainActivity
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Component(
    modules = [
        NetworkModule::class,
        DataModule::class,
        AppModule::class
    ]
)
internal interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}
