package com.example.hochiminhcity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hochiminhcity.R
import com.example.hochiminhcity.datasource.LocalSuggestionsProvider
import com.example.hochiminhcity.model.CityUiState
import com.example.hochiminhcity.model.Suggestion
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme
import com.example.hochiminhcity.ui.utils.CityContentType

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass
){
    val viewModel: CityViewModel = viewModel()
    val cityUiState = viewModel.uiState.collectAsState().value

    val contentType: CityContentType = when(windowSize) {
        WindowWidthSizeClass.Expanded -> CityContentType.LIST_AND_DETAIL
        else -> CityContentType.LIST_ONLY
    }
    if(contentType == CityContentType.LIST_AND_DETAIL) {
        Column {
            CityTopBar(
                onBack = { viewModel.resetUiState() },
                isShowingHomepage = cityUiState.isShowingHomepage,
                topBarTitle = R.string.app_name
            )
            if(cityUiState.isShowingHomepage) {
                CityCategories(
                    onCategoryClicked = { viewModel.updateCategory(category = it) }
                )
            } else {
                CitySuggestionsAndDetails(
                    onBack = { viewModel.resetUiState() },
                    onSuggestionClicked = {viewModel.updateSuggestion(suggestion = it)},
                    suggestions = cityUiState.currentCategory!!.list,
                    uiState = cityUiState,
                    contentType = contentType
                )
            }
        }
    } else {
        if(cityUiState.isShowingHomepage) {
            Column {
                CityTopBar(
                    onBack = {},
                    isShowingHomepage = true,
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
                        isShowingHomepage = false,
                        topBarTitle = cityUiState.currentCategory!!.name
                    )
                    CitySuggestionList(
                        onBack = { viewModel.resetUiState() },
                        onSuggestionClicked = {viewModel.updateSuggestion(suggestion = it)},
                        suggestions = cityUiState.currentCategory.list)
                }
            } else {
                Column {
                    CityTopBar(
                        onBack = { viewModel.backToCategory() },
                        isShowingHomepage = false,
                        topBarTitle = cityUiState.currentSuggestion!!.name
                    )
                    CitySuggestionDetails(
                        onBack = { viewModel.backToCategory() },
                        windowSize = windowSize,
                        suggestion = cityUiState.currentSuggestion
                    )
                }
            }
        }
    }
}

@Composable
fun CitySuggestionsAndDetails(
    onBack: () -> Unit,
    onSuggestionClicked: (Suggestion) -> Unit,
    suggestions: List<Suggestion>,
    uiState: CityUiState,
    contentType: CityContentType,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            ){
        CitySuggestionList(
            onBack = onBack,
            onSuggestionClicked = onSuggestionClicked,
            suggestions = suggestions,
            modifier = Modifier.weight(1f)
        )
        CitySuggestionDetails(
            contentType = contentType,
            onBack = onBack,
            suggestion = uiState.currentSuggestion?:suggestions[0],
            modifier = Modifier.weight(1.5f)
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ListAndDetailsPreview() {
    HoChiMinhCityTheme {
        CitySuggestionsAndDetails(
            onBack = { },
            onSuggestionClicked = {},
            suggestions = LocalSuggestionsProvider.coffeeSuggestions,
            uiState = CityUiState(),
            contentType = CityContentType.LIST_AND_DETAIL
        )
    }
}