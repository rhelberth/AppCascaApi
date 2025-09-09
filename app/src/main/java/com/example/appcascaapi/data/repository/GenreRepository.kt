package com.example.appcascaapi.data.repository

import kotlinx.coroutines.flow.Flow

// Renamed interface
interface GenreRepository {
    suspend fun getGenre(): Flow<Result<String>> 
}
