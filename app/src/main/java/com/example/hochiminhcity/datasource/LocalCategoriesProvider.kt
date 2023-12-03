package com.example.hochiminhcity.datasource

import com.example.hochiminhcity.R
import com.example.hochiminhcity.model.Category

object LocalCategoriesProvider {
    private val coffee = Category(
        name = R.string.coffee,
        image = R.drawable.coffee,
        list = LocalSuggestionsProvider.coffeeSuggestions
    )
    private val restaurant = Category(
        name = R.string.restaurant,
        image = R.drawable.restaurant,
        list = LocalSuggestionsProvider.restaurantSuggestions
    )
    private val activity = Category(
        name = R.string.activity,
        image = R.drawable.activity,
        list = LocalSuggestionsProvider.activitySuggestions
    )
    val categories = listOf(
        coffee, restaurant, activity
    )
}