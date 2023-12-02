package com.example.hochiminhcity.datasource

import com.example.hochiminhcity.R
import com.example.hochiminhcity.model.Suggestion.Coffee
import com.example.hochiminhcity.model.Suggestion.Restaurant
import com.example.hochiminhcity.model.Suggestion.Activity

object LocalSuggestionsProvider {
    private val coffee = listOf(
        Coffee(
            name = R.string.coffee_1,
            image = R.drawable.coffee_1,
            description = R.string.description_coffee_1
        ),
        Coffee(
            name = R.string.coffee_2,
            image = R.drawable.coffee_2,
            description = R.string.description_coffee_2
        ),
        Coffee(
            name = R.string.coffee_3,
            image = R.drawable.coffee_3,
            description = R.string.description_coffee_3
        ),
        Coffee(
            name = R.string.coffee_4,
            image = R.drawable.coffee_4,
            description = R.string.description_coffee_4
        ),
        Coffee(
            name = R.string.coffee_5,
            image = R.drawable.coffee_5,
            description = R.string.description_coffee_5
        ),
        Coffee(
            name = R.string.coffee_6,
            image = R.drawable.coffee_6,
            description = R.string.description_coffee_6
        ),
        Coffee(
            name = R.string.coffee_7,
            image = R.drawable.coffee_7,
            description = R.string.description_coffee_7
        ),
        Coffee(
            name = R.string.coffee_8,
            image = R.drawable.coffee_8,
            description = R.string.description_coffee_8
        ),
        Coffee(
            name = R.string.coffee_9,
            image = R.drawable.coffee_9,
            description = R.string.description_coffee_9
        ),
        Coffee(
            name = R.string.coffee_10,
            image = R.drawable.coffee_10,
            description = R.string.description_coffee_10
        ),
    )
    private val restaurant = listOf(
        Restaurant(
            name = R.string.restaurant_1,
            image = R.drawable.restaurant_1,
            description = R.string.description_restaurant_1
        ),
        Restaurant(
            name = R.string.restaurant_2,
            image = R.drawable.restaurant_2,
            description = R.string.description_restaurant_2
        ),
        Restaurant(
            name = R.string.restaurant_3,
            image = R.drawable.restaurant_3,
            description = R.string.description_restaurant_3
        ),
        Restaurant(
            name = R.string.restaurant_4,
            image = R.drawable.restaurant_4,
            description = R.string.description_restaurant_4
        ),
        Restaurant(
            name = R.string.restaurant_5,
            image = R.drawable.restaurant_5,
            description = R.string.description_restaurant_5
        ),
        Restaurant(
            name = R.string.restaurant_6,
            image = R.drawable.restaurant_6,
            description = R.string.description_restaurant_6
        ),
        Restaurant(
            name = R.string.restaurant_7,
            image = R.drawable.restaurant_7,
            description = R.string.description_restaurant_7
        ),
        Restaurant(
            name = R.string.restaurant_8,
            image = R.drawable.restaurant_8,
            description = R.string.description_restaurant_8
        ),
        Restaurant(
            name = R.string.restaurant_9,
            image = R.drawable.restaurant_9,
            description = R.string.description_restaurant_9
        ),
    )
    private val activity = listOf(
        Activity(
            name = R.string.activity_1,
            image = R.drawable.activity_1,
            description = R.string.description_activity_1
        ),
        Activity(
            name = R.string.activity_2,
            image = R.drawable.activity_2,
            description = R.string.description_activity_2
        ),
        Activity(
            name = R.string.activity_3,
            image = R.drawable.activity_3,
            description = R.string.description_activity_3
        ),
        Activity(
            name = R.string.activity_4,
            image = R.drawable.activity_4,
            description = R.string.description_activity_4
        ),
        Activity(
            name = R.string.activity_5,
            image = R.drawable.activity_5,
            description = R.string.description_activity_5
        ),
        Activity(
            name = R.string.activity_6,
            image = R.drawable.activity_6,
            description = R.string.description_activity_6
        ),
        Activity(
            name = R.string.activity_7,
            image = R.drawable.activity_7,
            description = R.string.description_activity_7
        ),
        Activity(
            name = R.string.activity_8,
            image = R.drawable.activity_8,
            description = R.string.description_activity_8
        ),
        Activity(
            name = R.string.activity_9,
            image = R.drawable.activity_9,
            description = R.string.description_activity_9
        ),
        Activity(
            name = R.string.activity_10,
            image = R.drawable.activity_10,
            description = R.string.description_activity_10
        ),
    )
}