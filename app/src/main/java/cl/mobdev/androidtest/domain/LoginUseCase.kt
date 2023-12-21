package cl.mobdev.androidtest.domain

import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authenticationService: AuthenticationService) {
    suspend operator fun invoke(email: String, password: String) =
        authenticationService.login(email, password)
}
