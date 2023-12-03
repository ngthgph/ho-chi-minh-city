package com.example.hochiminhcity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val list: List<Suggestion>
)
