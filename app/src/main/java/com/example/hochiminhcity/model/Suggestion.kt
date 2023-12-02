package com.example.hochiminhcity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class Suggestion(
    @StringRes open val name: Int,
    @DrawableRes open val image: Int,
    @StringRes open val description: Int,
) {
    data class Coffee(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        @StringRes override val description: Int,
    ): Suggestion(name, image, description)

    data class Restaurant(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        @StringRes override val description: Int,
    ): Suggestion(name, image, description)

    data class Activity(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        @StringRes override val description: Int,
    ): Suggestion(name, image, description)
}
