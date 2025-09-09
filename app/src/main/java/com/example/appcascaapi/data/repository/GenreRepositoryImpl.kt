package com.example.appcascaapi.data.repository

import com.example.appcascaapi.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

// Renamed class and implements GenreRepository
class GenreRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GenreRepository { // Updated to implement GenreRepository

    override suspend fun getGenre(): Flow<Result<String>> = flow {
        try {
            val response = apiService.getGenre()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.success(it))
                } ?: emit(Result.failure(Exception("Response body is null")))
            } else {
                emit(Result.failure(Exception("API Error: ${response.code()} ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(Exception("Network or other error: ${e.message}", e)))
        }
    }.flowOn(Dispatchers.IO)
}
