package cl.mobdev.androidtest.data.remote.model

import cl.mobdev.androidtest.data.remote.model.Constants.TOKEN
import com.google.gson.annotations.SerializedName

data class RemoteSignUpParams(@SerializedName(TOKEN) val token: String)