package com.example.appcascaapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
// Updated to GetRandomGenreUseCase
import com.example.appcascaapi.domain.usecase.GetRandomGenreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(
    // Updated to inject GetRandomGenreUseCase
    private val getRandomGenreUseCase: GetRandomGenreUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GenreUiState())
    val uiState: StateFlow<GenreUiState> = _uiState.asStateFlow()

    init {
        fetchGenre()
    }

    fun fetchGenre() {
        viewModelScope.launch {
            _uiState.value = GenreUiState(isLoading = true)
            // Updated to call the use case (as a function due to invoke operator)
            getRandomGenreUseCase()
                .onEach { result ->
                    result.fold(
                        onSuccess = {
                            _uiState.value = GenreUiState(genre = it)
                        },
                        onFailure = {
                            _uiState.value = GenreUiState(error = it.message ?: "Unknown error")
                        }
                    )
                }
                .launchIn(viewModelScope)
        }
    }
}
