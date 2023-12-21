package cl.mobdev.androidtest.data.remote.model

import cl.mobdev.androidtest.data.remote.model.Constants.CODE
import cl.mobdev.androidtest.data.remote.model.Constants.MESSAGE
import com.google.gson.annotations.SerializedName

data class RemoteSignUpResponse(
    @SerializedName(CODE) val statusCode: Int,
    @SerializedName(MESSAGE) val message: String
)
