package dev.mindscape.moneyxchange.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mindscape.moneyxchange.screens.ExchangeScreen
import dev.mindscape.moneyxchange.screens.FavoritesScreen
import dev.mindscape.moneyxchange.screens.HomeScreen

@Composable
fun BottomNavGraph(navController : NavHostController){
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route)
    {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorites.route){
            FavoritesScreen()
        }
        composable(route = BottomBarScreen.Exchange.route){
            ExchangeScreen()
        }
    }
}