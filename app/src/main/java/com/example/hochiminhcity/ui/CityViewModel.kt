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

    private fun resetUiState() {
        _uiState.value = CityUiState(
            currentCategory = null,
            currentSuggestion = null,
            isShowingHomepage = true,
        )
    }

    fun updateCategory(category: Category) {
        _uiState.update {
            it.copy(currentCategory = category)
        }
    }

    fun updateSuggestion(suggestion: Suggestion) {
        _uiState.update {
            it.copy(currentSuggestion = suggestion)
        }
    }
}