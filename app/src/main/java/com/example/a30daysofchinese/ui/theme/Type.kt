package com.example.a30daysofchinese.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30daysofchinese.R

val Kalam = FontFamily(
    Font(R.font.kalam_bold, FontWeight.Bold),
    Font(R.font.kalam_regular, FontWeight.Normal),
    Font(R.font.kalam_light, FontWeight.Light)
)

val Typography = Typography(
    defaultFontFamily = Kalam,
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)