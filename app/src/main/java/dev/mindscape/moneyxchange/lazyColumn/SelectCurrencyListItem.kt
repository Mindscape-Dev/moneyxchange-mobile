package dev.mindscape.moneyxchange.lazyColumn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.mindscape.moneyxchange.data.Currency
import dev.mindscape.moneyxchange.data.Launcher
import dev.mindscape.moneyxchange.graph.Screen
import kotlinx.coroutines.launch

@Composable
fun SelectCurrencyListItem(selectCurrency: Currency, navController: NavController){

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val ds = Launcher(context)

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                scope.launch {
                    ds.isFirstLaunch(false)
                    navController.popBackStack()
                    navController.navigate(Screen.Main.route)
                }

            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = selectCurrency.name,
                fontSize = 18.sp,
                color = Color.White
            )

        }
    }
}