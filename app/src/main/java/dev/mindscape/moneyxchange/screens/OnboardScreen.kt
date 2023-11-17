package dev.mindscape.moneyxchange.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import dev.mindscape.moneyxchange.R
import dev.mindscape.moneyxchange.data.OnboardingData
import dev.mindscape.moneyxchange.graph.Screen
import dev.mindscape.moneyxchange.ui.theme.BottomCardShape
import dev.mindscape.moneyxchange.ui.theme.Poppins
import dev.mindscape.moneyxchange.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardScreen(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()){
        val items = ArrayList<OnboardingData>()
        items.add(
            OnboardingData(
                R.drawable.first,
                backgroundColor = Color(0xFF040210),
                mainColor = Yellow,
                mainText = "Real-Time Currency Updates at Your Fingertips",
                subText = "Stay updated on real-time currency rates with MoneyXChange! " +
                        "Access the latest exchange values for various currencies, ensuring " +
                        "you’re always informed about market fluctuations."
            )
        )
        items.add(
            OnboardingData(R.drawable.second,
                backgroundColor = Color(0xFF0a020f),
                mainColor = Yellow,
                mainText = "Effortless Currency Conversions Made Easy",
                subText = "Seamlessly convert between different currency pairs using MoneyXChange! " +
                        "Enjoy the convenience of swift and accurate currency conversions, " +
                        "making international transactions and travel hassle-free."
            )
        )
        items.add(
            OnboardingData(R.drawable.third,
                backgroundColor = Color(0xFF171624),
                mainColor = Yellow,
                mainText = "Your Tailored Exchange Rate Solution!",
                subText = "Customize your currency tracking experience with MoneyXChange! " +
                        "Simply double-tap to add your preferred currencies to your favorites list, " +
                        "creating a tailored and efficient way to monitor specific exchange rates."
            )
        )

        val pagerState = rememberPagerState(
            pageCount = items.size,
            initialOffscreenLimit = 2,
            infiniteLoop = false,
            initialPage = 0)

        OnboardingPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier.fillMaxSize(),
            navController
        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(
    item: List<OnboardingData>,
    pagerState: com.google.accompanist.pager.PagerState,
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Box(modifier = modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(painter = painterResource(
                        id = item[page].image),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth())
                }

            }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                shape = BottomCardShape.large,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ){
                Box{
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PagerIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].mainText,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, end = 30.dp),
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = Poppins,
                            textAlign = TextAlign.Right,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = item[pagerState.currentPage].subText,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, start = 40.dp, end = 20.dp),
                            color = Color(0xFFdde0e4),
                            fontFamily = Poppins,
                            textAlign = TextAlign.Center,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraLight
                        )
                    }
                }


            }
            Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    if(pagerState.currentPage!=2){
                        TextButton(onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.Select.route)
                        }) {
                            Text(text = "Skip",
                                color = Color(0xFF54575b),
                                fontFamily = Poppins,
                                textAlign = TextAlign.Right,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold)
                        }

                        val scope = rememberCoroutineScope()
                        OutlinedButton(onClick = {scope.launch{pagerState.animateScrollToPage(pagerState.currentPage + 1,
                            pageOffset = 0f)}},
                            border = BorderStroke(
                                14.dp,
                                item[pagerState.currentPage].mainColor
                            ),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = item[pagerState.currentPage].mainColor
                            ),
                            modifier = Modifier.size(65.dp)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.ic_right_arrow) ,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }else{
                        Button(onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.Select.route) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = item[pagerState.currentPage].mainColor
                            ),
                            contentPadding = PaddingValues(vertical = 12.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 0.dp
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Get Started",
                                color = Color(0xFFdde0e4),
                                fontSize = 16.sp)
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun PagerIndicator(items : List<OnboardingData>, currentPage : Int){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ){
        repeat(items.size){
            Indicator(
                isSelected = it == currentPage,
                color = items[it].mainColor
            )
        }
    }
}

@Composable
fun Indicator(isSelected : Boolean, color : Color){
    val width = animateDpAsState(targetValue = if(isSelected) 40.dp else 10.dp, label = "")
    Box(modifier = Modifier
        .padding(4.dp)
        .height(10.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(
            if (isSelected) color else Color.Gray.copy(alpha = 0.5f)
        )
    )
}