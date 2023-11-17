package dev.mindscape.moneyxchange.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.mindscape.moneyxchange.R
import dev.mindscape.moneyxchange.data.Launcher
import dev.mindscape.moneyxchange.graph.Screen
import dev.mindscape.moneyxchange.ui.theme.BackgroundColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController : NavController){

    val context = LocalContext.current
    val ds = Launcher(context)
    val scope = rememberCoroutineScope()

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ), label = "animation"
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(3000)
        if(ds.checkFirstLaunch()){
            navController.navigate(Screen.Onboard.route)
        }else{
            navController.navigate(Screen.Main.route)
        }
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha:Float){
    Box(modifier = Modifier
        .background(color = BackgroundColor)
        .fillMaxSize(),
        contentAlignment = Alignment.Center){

        Image(painter = painterResource(id = R.drawable.logo_mini),
            contentDescription = "brand logo",
            modifier = Modifier
                .size(150.dp)
                .alpha(alpha = alpha)
        )

    }
}