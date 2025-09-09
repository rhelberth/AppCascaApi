package com.example.appcascaapi.ui.viewmodel

data class GenreUiState(
    val isLoading: Boolean = false,
    val genre: String? = null,
    val error: String? = null
)
