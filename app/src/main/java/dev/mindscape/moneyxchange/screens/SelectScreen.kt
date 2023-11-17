package dev.mindscape.moneyxchange.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.mindscape.moneyxchange.R
import dev.mindscape.moneyxchange.data.CurrencyData
import dev.mindscape.moneyxchange.lazyColumn.SelectCurrencyListItem
import dev.mindscape.moneyxchange.ui.theme.*
import dev.mindscape.moneyxchange.ui.theme.MoneyXChangeTheme

@SuppressLint("RememberReturnType")
@Composable
fun SelectScreen(navController: NavHostController){
    val currency = remember { CurrencyData.CurrencyLists }
    val getFontFamily = FontFamily(
        Font(R.font.eras)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(text = "Select Your Currency",
            fontSize = 26.sp,
            color = Yellow,
            fontFamily = getFontFamily,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 15.dp))

        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
            items(
                items = currency,
                itemContent = {
                    SelectCurrencyListItem(selectCurrency = it, navController)
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Pr(){
    MoneyXChangeTheme {
        SelectScreen(navController = rememberNavController())
    }
}
