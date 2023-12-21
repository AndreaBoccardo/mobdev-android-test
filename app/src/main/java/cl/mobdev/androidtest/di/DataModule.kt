package cl.mobdev.androidtest.di

import cl.mobdev.androidtest.data.remote.ApiRemoteImpl
import cl.mobdev.androidtest.data.remote.source.ApiRemote
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataModule {
    @Binds
    abstract fun provideApiRepository(apiRemoteImpl: ApiRemoteImpl): ApiRemote
}
