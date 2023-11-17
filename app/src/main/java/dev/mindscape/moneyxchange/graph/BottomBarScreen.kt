package dev.mindscape.moneyxchange.graph

import dev.mindscape.moneyxchange.R

sealed class BottomBarScreen(
    val route : String,
    val title : String,
    val icon : Int,
    val iconFocused : Int
){
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.home,
        iconFocused = R.drawable.home_focused
    )

    object Favorites : BottomBarScreen(
        route = "favorites",
        title = "Favorites",
        icon = R.drawable.favorites,
        iconFocused = R.drawable.favorites_focused
    )

    object Exchange : BottomBarScreen(
        route = "exchange",
        title = "Exchange",
        icon = R.drawable.exchange,
        iconFocused = R.drawable.exchange_focused
    )
}
