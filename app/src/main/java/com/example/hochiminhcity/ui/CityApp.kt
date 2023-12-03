package com.example.hochiminhcity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hochiminhcity.R
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme

@Composable
fun CityApp(){
    val viewModel: CityViewModel = viewModel()
    val cityUiState = viewModel.uiState.collectAsState().value

    if(cityUiState.isShowingHomepage) {
        Column {
            CityTopBar(
                onBack = {},
                isShowingHomepage = cityUiState.isShowingHomepage,
                topBarTitle = R.string.app_name
            )
            CityCategories(
                onCategoryClicked = { viewModel.updateCategory(category = it) }
            )
        }

    } else {
        if(!cityUiState.isOnDetailsPage) {
            Column {
                CityTopBar(
                    onBack = { viewModel.resetUiState() },
                    isShowingHomepage = cityUiState.isShowingHomepage,
                    topBarTitle = cityUiState.currentCategory!!.name
                )
                CitySuggestionList(
                    onSuggestionClicked = {viewModel.updateSuggestion(suggestion = it)},
                    suggestions = cityUiState.currentCategory.list)
            }
        } else {
            Column {
                CityTopBar(
                    onBack = { viewModel.backToCategory() },
                    isShowingHomepage = cityUiState.isShowingHomepage,
                    topBarTitle = cityUiState.currentSuggestion!!.name
                )
                CitySuggestionDetails(suggestion = cityUiState.currentSuggestion)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppPreview() {
    HoChiMinhCityTheme {
        CityApp()
    }
}