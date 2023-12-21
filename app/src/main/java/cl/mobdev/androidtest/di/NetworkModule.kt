package cl.mobdev.androidtest.di

import cl.mobdev.androidtest.BuildConfig
import cl.mobdev.androidtest.data.remote.retrofit.ApiWebService
import cl.mobdev.androidtest.di.Constants.DEV
import cl.mobdev.androidtest.di.Constants.DEV_URL
import cl.mobdev.androidtest.di.Constants.THIRTY
import cl.mobdev.androidtest.domain.AuthenticationService
import cl.mobdev.androidtest.network.AuthInterceptor
import cl.mobdev.androidtest.network.FirebaseClient
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    @Provides
    fun url(): String {
        return DEV_URL
    }

    @Provides
    fun provideRetrofit(
        url: String,
        client: OkHttpClient
    ): Retrofit {
        if (BuildConfig.FLAVOR == DEV) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val authInterceptor = AuthInterceptor()

            val okHttpClient =
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(authInterceptor)
                    .connectTimeout(THIRTY.toLong(), TimeUnit.SECONDS)
                    .readTimeout(THIRTY.toLong(), TimeUnit.SECONDS)
                    .build()

            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        } else {
            return Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Provides
    fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .connectTimeout(THIRTY.toLong(), TimeUnit.SECONDS)
            .readTimeout(THIRTY.toLong(), TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideApiWebService(retrofit: Retrofit): ApiWebService {
        return retrofit.create(ApiWebService::class.java)
    }

    @Provides
    fun provideAuthentication(): AuthenticationService {
        return AuthenticationService(FirebaseClient())
    }


}