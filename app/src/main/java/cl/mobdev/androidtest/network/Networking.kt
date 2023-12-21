package cl.mobdev.androidtest.network

import android.util.Log
import cl.mobdev.androidtest.data.remote.model.RemoteSignUpParams
import cl.mobdev.androidtest.data.remote.model.RemoteSignUpResponse
import cl.mobdev.androidtest.data.remote.retrofit.ApiWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Networking {
    fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.url_prod)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    suspend fun postLoginStatus(token: RemoteSignUpParams): RemoteSignUpResponse {
        runCatching {
            withContext(Dispatchers.IO) {
                getRetrofit().create(ApiWebService::class.java).signUP("/signUp", token)
            }
        }.fold(
            onSuccess = { response ->
                Log.d("Endpoint Info", response.code().toString())
                Log.d("Endpoint Info", response.body()?.messageResponse.orEmpty())

                return RemoteSignUpResponse(
                    statusCode = response.code(),
                    message = response.body()?.messageResponse.orEmpty()
                )
            },
            onFailure = { error ->
                Log.e("Endpoint", error.toString())
                return RemoteSignUpResponse(
                    statusCode = 400,
                    message = error.message.toString()
                )
            }
        )
    }
}
