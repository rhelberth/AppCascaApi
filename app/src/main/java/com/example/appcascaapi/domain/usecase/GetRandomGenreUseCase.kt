package com.example.appcascaapi.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetRandomGenreUseCase {
    // Using invoke operator to allow calling the use case as a function
    suspend operator fun invoke(): Flow<Result<String>>
}
