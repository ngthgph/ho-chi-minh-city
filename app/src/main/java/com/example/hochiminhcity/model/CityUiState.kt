package com.example.hochiminhcity.model

data class CityUiState(
    val currentCategory: Category? = null,
    val currentSuggestion: Suggestion? = null,
    val isShowingHomepage: Boolean = true,
    val isOnDetailsPage: Boolean = false,
)
