package com.example.hochiminhcity.model

import androidx.annotation.StringRes

data class Category(
    @StringRes val name: Int,
    val list: List<Suggestion>
)
