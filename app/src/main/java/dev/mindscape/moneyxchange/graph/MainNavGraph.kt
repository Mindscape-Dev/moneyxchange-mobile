package dev.mindscape.moneyxchange.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.mindscape.moneyxchange.screens.MainScreen
import dev.mindscape.moneyxchange.screens.OnboardScreen
import dev.mindscape.moneyxchange.screens.SelectScreen
import dev.mindscape.moneyxchange.screens.SplashScreen

fun NavGraphBuilder.MainNavGraph(navController: NavHostController){
    navigation(startDestination = Screen.Splash.route,
        route = Graph.MAIN)
    {
        composable(Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.Onboard.route){
            OnboardScreen(navController = navController)
        }
        composable(Screen.Select.route){
            SelectScreen(navController = navController)
        }
        composable(Screen.Main.route){
            MainScreen()
        }
    }
}