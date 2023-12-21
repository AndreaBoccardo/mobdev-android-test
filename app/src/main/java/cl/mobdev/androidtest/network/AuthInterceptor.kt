package cl.mobdev.androidtest.network

import android.util.Log
import cl.mobdev.androidtest.di.Constants.AUTH_TOKEN_NAME
import cl.mobdev.androidtest.presentation.SharedPreferencesLogin
import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = SharedPreferencesLogin.fetchAuthToken()
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .addHeader(
                AUTH_TOKEN_NAME,
                "Bearer $token"
            )
            .build()
        val response = chain.proceed(modifiedRequest)
        response.headers.names().forEach { name ->
            Log.d("HEADER", "$name: ${response.headers[name]}")
        }
        return response
    }
}
