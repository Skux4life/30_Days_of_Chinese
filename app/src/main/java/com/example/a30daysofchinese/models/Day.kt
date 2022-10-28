package com.example.a30daysofchinese.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    val day: Int,
    @DrawableRes val characterImage: Int,
    @StringRes val pinyin: Int,
    @StringRes val definition: Int
) {
}