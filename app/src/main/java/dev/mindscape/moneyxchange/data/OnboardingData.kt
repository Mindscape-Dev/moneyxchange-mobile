package dev.mindscape.moneyxchange.data

import androidx.compose.ui.graphics.Color
import dev.mindscape.moneyxchange.ui.theme.BackgroundColor

class OnboardingData(
    val image : Int,
    val backgroundColor : Color = BackgroundColor,
    val mainColor : Color = BackgroundColor,
    val mainText : String,
    val subText : String
) {
}