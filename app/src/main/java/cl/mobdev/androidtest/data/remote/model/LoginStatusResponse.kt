package cl.mobdev.androidtest.data.remote.model

import cl.mobdev.androidtest.data.remote.model.Constants.MESSAGE
import com.google.gson.annotations.SerializedName

data class LoginStatusResponse(@SerializedName(MESSAGE) val messageResponse: String)
