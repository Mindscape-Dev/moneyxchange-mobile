package dev.mindscape.moneyxchange.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mindscape.moneyxchange.screens.MainScreen

@Composable
fun RootNavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController,
        startDestination = Graph.MAIN ,
        route = Graph.ROOT )
    {
        MainNavGraph(navController = navHostController)
        composable(route = Graph.BOTTOM){
            MainScreen()
        }
    }
}

object Graph{
    const val ROOT = "rootGraph"
    const val MAIN = "mainGraph"
    const val BOTTOM = "bottomGraph"
}