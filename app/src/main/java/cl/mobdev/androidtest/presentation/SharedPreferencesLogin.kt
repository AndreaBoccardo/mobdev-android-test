package cl.mobdev.androidtest.presentation

object SharedPreferencesLogin {

    private var tokenShared = ""

    fun saveAuthToken(token: String) {
        tokenShared = token;
    }

    fun fetchAuthToken(): String? {
        return tokenShared
    }
}
