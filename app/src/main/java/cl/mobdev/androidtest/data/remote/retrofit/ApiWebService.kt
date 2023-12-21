package cl.mobdev.androidtest.data.remote.retrofit

import cl.mobdev.androidtest.data.remote.model.LoginStatusResponse
import cl.mobdev.androidtest.data.remote.model.RemoteSignUpParams
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiWebService {
    @POST
    suspend fun signUP(
        @Url url: String,
        @Body token: RemoteSignUpParams
    ): Response<LoginStatusResponse>
}
