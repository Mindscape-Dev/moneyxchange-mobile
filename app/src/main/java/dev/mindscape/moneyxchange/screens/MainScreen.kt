package dev.mindscape.moneyxchange.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.mindscape.moneyxchange.graph.BottomBarScreen
import dev.mindscape.moneyxchange.graph.BottomNavGraph
import dev.mindscape.moneyxchange.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold (
        containerColor = BackgroundColor,
        bottomBar ={ BottomBar(navController = navController)}
    ){
        BottomNavGraph(navController = navController)
    }

}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Exchange,
        BottomBarScreen.Home,
        BottomBarScreen.Favorites
    )

    val navStackbackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackbackEntry?.destination

    Row(
        modifier = Modifier
            .background(BackgroundColor)
            .clip(CircleShape)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.padding(start = 10.dp))
        screens.forEach{ screen ->
            AddItem(screen = screen,
                currentDestination = currentDestination,
                navController = navController)
        }
        Spacer(modifier = Modifier.padding(start = 10.dp))
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination : NavDestination?,
    navController: NavHostController
){
    val selected = currentDestination?.hierarchy?.any{it.route == screen.route} == true

    val background =
        if (selected){
            Yellow
        }else{
            Color.Transparent
        }

    val contentColor =
        if(selected){
            DarkGray
        }else{
            Color.White
        }
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(background)
        .clickable(onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
    ){
        Row(modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp))
        {
            Icon(painter = painterResource(id = if(selected) screen.iconFocused else screen.icon),
                contentDescription = "",
                tint = contentColor)
            AnimatedVisibility(visible = selected) {
                Text(text = screen.title,
                    color = contentColor)
            }
        }
    }
}

