package com.example.a30daysofchinese.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DarkPrimary,
    primaryVariant = DarkPrimaryVariant,
    secondary = DarkSecondary,
    background = DarkBackground,
    surface = DarkPrimary
)

private val LightColorPalette = lightColors(
    primary = LightPrimary,
    primaryVariant = LightPrimaryVariant,
    secondary = LightSecondary,
    background = LightBackground,
    surface = LightPrimary
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ThirtyDaysOfChineseTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}