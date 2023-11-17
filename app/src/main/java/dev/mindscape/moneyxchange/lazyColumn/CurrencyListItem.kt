package dev.mindscape.moneyxchange.lazyColumn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mindscape.moneyxchange.data.Currency
import dev.mindscape.moneyxchange.ui.theme.*

@Composable
fun CurrencyListItem(Currency: Currency, selectedCurrency : String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = DarkGray
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){

        Row {
            Row(
                modifier = Modifier.size(200.dp,80.dp)
            ){
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ){
                    Text(text = Currency.name,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White)
                }


            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(text = "Buy($selectedCurrency)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Yellow
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Text(text = Currency.buy,
                        fontSize = 14.sp,
                        color = Color.White)
                }
            }

            Spacer(modifier = Modifier.padding(start = 25.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(text = "Sell($selectedCurrency)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Yellow
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text(text = Currency.sell,
                    fontSize = 14.sp,
                    color = Color.White)
            }
        }
    }
}