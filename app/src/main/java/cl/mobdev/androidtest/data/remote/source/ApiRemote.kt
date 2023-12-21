package cl.mobdev.androidtest.data.remote.source

import cl.mobdev.androidtest.data.remote.model.LoginStatusResponse
import cl.mobdev.androidtest.data.remote.model.RemoteSignUpParams
import retrofit2.Response

interface ApiRemote {
    suspend fun signUP(url: String, token: RemoteSignUpParams): Response<LoginStatusResponse>
}
