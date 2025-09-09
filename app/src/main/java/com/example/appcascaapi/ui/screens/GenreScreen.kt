package com.example.appcascaapi.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appcascaapi.ui.theme.AppCascaApiTheme
import com.example.appcascaapi.ui.viewmodel.GenreViewModel

@Composable
fun GenreScreen(
    modifier: Modifier = Modifier,
    viewModel: GenreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                uiState.isLoading -> {
                    CircularProgressIndicator()
                }
                uiState.error != null -> {
                    Text(
                        text = "Error: ${uiState.error}",
                        color = MaterialTheme.colorScheme.error
                    )
                }
                uiState.genre != null -> {
                    GenreDisplay(genre = uiState.genre!!)
                }
                else -> {
                    Text(text = "Fetching genre...")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { viewModel.fetchGenre() }) {
                Text("Fetch New Genre")
            }
        }
    }
}

@Composable
fun GenreDisplay(genre: String, modifier: Modifier = Modifier) {
    Text(
        text = genre,
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Preview(showBackground = true)
@Composable
fun GenreDisplayPreview() {
    AppCascaApiTheme {
        GenreDisplay("Synthwave Pop")
    }
}

@Preview(showBackground = true, name = "Loading State")
@Composable
fun GenreScreenLoadingPreview() {
    AppCascaApiTheme {
        // Simulate the screen with button
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {}) {
                Text("Fetch New Genre")
            }
        }
    }
}

@Preview(showBackground = true, name = "Error State")
@Composable
fun GenreScreenErrorPreview() {
    AppCascaApiTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Error: Could not load genre",
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {}) {
                Text("Fetch New Genre")
            }
        }
    }
}

@Preview(showBackground = true, name = "Success State")
@Composable
fun GenreScreenSuccessPreview() {
    AppCascaApiTheme {
        GenreScreenContentPreview("Progressive Rock")
    }
}

@Composable
private fun GenreScreenContentPreview(genre: String) {
    // Simulate the screen with button
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GenreDisplay(genre = genre)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}) {
            Text("Fetch New Genre")
        }
    }
}
