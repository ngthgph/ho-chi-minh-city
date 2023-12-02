package com.example.hochiminhcity.datasource

import com.example.hochiminhcity.R
import com.example.hochiminhcity.model.Category

object LocalCategoriesProvider {
    val coffee = Category(
        name = R.string.coffee,
        list = LocalSuggestionsProvider.coffeeSuggestions
    )
    val restaurant = Category(
        name = R.string.restaurant,
        list = LocalSuggestionsProvider.restaurantSuggestions
    )
    val activity = Category(
        name = R.string.activity,
        list = LocalSuggestionsProvider.activitySuggestions
    )
}