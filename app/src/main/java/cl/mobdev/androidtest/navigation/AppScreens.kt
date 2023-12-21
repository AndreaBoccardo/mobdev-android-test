package cl.mobdev.androidtest.navigation

sealed class AppScreens(val route: String) {
    object OnBoardingCreateEvent : AppScreens(ONBOARDING_CREATE_EVENT)
    object OnBoardingPaymentsReceipts : AppScreens(ONBOARDING_PAYMENTS_RECEIPTS)
    object HomeScreen : AppScreens(HOME_SCREEN)
    object StartSession : AppScreens(START_SESSION)

    companion object {
        const val ONBOARDING_CREATE_EVENT = "onboarding_create_event"
        const val ONBOARDING_PAYMENTS_RECEIPTS = "onboarding_payments_receipts"
        const val HOME_SCREEN = "home_screen"
        const val START_SESSION = "start_session"
    }
}
