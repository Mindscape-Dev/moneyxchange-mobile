package dev.mindscape.moneyxchange.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.navOptions
import dev.mindscape.moneyxchange.data.CurrencyData.CurrencyLists

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeScreen(){

    var isExpended by remember{
        mutableStateOf(false)
    }

    var cname by remember{
        mutableStateOf("")
    }

    var selectedPrice by remember{
        mutableStateOf("")
    }

    val currency = CurrencyLists.map {currency -> "${currency.name} - ${currency.sell}"}


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
       ){

        ExposedDropdownMenuBox(expanded = isExpended,
            onExpandedChange = { isExpended = it },
            modifier = Modifier.size(200.dp))
        {
            OutlinedTextField(
                value = cname,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Select Currency")},
                trailingIcon = {
                  ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpended)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpended,
                onDismissRequest = { isExpended = false }
            ) {
                currency.forEach{ currency ->
                    val name = currency.split(" - ")[0]
                    val price = currency.split(" - ")[1]
                    DropdownMenuItem(text = { Text(text = name) },
                        onClick = {
                            cname = name
                            selectedPrice = price
                            isExpended = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)
                }
            }
        }
        Button(onClick = { println(selectedPrice.toDouble()) }) {
            Text(text = "Print")
        }
    }
    

}

//@Composable
//@Preview(showSystemUi = true, showBackground = true)
//fun ExchangePreview(){
//    ExchangeScreen()
//}