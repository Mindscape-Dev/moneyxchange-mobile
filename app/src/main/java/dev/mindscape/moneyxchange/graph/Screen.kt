package dev.mindscape.moneyxchange.graph

sealed class Screen(val route : String){
    object Splash : Screen("splashScreen")
    object Onboard : Screen("onboardScreen")
    object Select : Screen("selectScreen")
    object Main : Screen("mainScreen")
}
