package cl.mobdev.androidtest.data.remote

import cl.mobdev.androidtest.data.remote.model.LoginStatusResponse
import cl.mobdev.androidtest.data.remote.model.RemoteSignUpParams
import cl.mobdev.androidtest.data.remote.retrofit.ApiWebService
import cl.mobdev.androidtest.data.remote.source.ApiRemote
import retrofit2.Response
import javax.inject.Inject

class ApiRemoteImpl @Inject constructor(
    private val webService: ApiWebService
) : ApiRemote {
    override suspend fun signUP(
        url: String,
        token: RemoteSignUpParams
    ): Response<LoginStatusResponse> = webService.signUP(url = url, token = token)
}
