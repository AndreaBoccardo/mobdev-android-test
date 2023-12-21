package cl.mobdev.androidtest.data

import cl.mobdev.androidtest.data.remote.model.LoginStatusResponse
import cl.mobdev.androidtest.data.remote.model.RemoteSignUpParams
import cl.mobdev.androidtest.data.remote.source.ApiRemote
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(private val remote: ApiRemote) {
    suspend fun signUP(url: String, token: RemoteSignUpParams): Response<LoginStatusResponse> =
        remote.signUP(url = url, token = token)
}
