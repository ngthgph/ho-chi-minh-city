package com.example.hochiminhcity.ui

import androidx.lifecycle.ViewModel
import com.example.hochiminhcity.model.Category
import com.example.hochiminhcity.model.CityUiState
import com.example.hochiminhcity.model.Suggestion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

    fun resetUiState() {
        _uiState.value = CityUiState(
            currentCategory = null,
            currentSuggestion = null,
            isShowingHomepage = true,
            isOnDetailsPage = false
        )
    }

    fun updateCategory(category: Category) {
        _uiState.update {
            it.copy(
                currentCategory = category,
                isShowingHomepage = false,
            )
        }
    }

    fun backToCategory() {
        _uiState.update {
            it.copy(
                currentSuggestion = null,
                isOnDetailsPage = false
            )
        }
    }

    fun updateSuggestion(suggestion: Suggestion) {
        _uiState.update {
            it.copy(
                currentSuggestion = suggestion,
                isOnDetailsPage = true,
            )
        }
    }
}