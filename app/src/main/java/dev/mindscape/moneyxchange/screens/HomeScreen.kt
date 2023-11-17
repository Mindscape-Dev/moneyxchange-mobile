package dev.mindscape.moneyxchange.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.mindscape.moneyxchange.data.CurrencyData
import dev.mindscape.moneyxchange.lazyColumn.CurrencyListItem
import dev.mindscape.moneyxchange.ui.theme.*

@Composable
fun HomeScreen(navHostController: NavHostController){
    val currency = remember{ CurrencyData.CurrencyLists}

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            color = BackgroundColor
        )

    ){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.padding(bottom = 50.dp)){
                items(
                    items = currency,
                    itemContent = {
                        CurrencyListItem(Currency = it, selectedCurrency = "TL")
                    }
                )
            }
        }
    }
}