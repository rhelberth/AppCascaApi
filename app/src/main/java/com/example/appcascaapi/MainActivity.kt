package com.example.appcascaapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
// Updated import to GenreScreen
import com.example.appcascaapi.ui.screens.GenreScreen 
import com.example.appcascaapi.ui.theme.AppCascaApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCascaApiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Updated to call GenreScreen
                    GenreScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
