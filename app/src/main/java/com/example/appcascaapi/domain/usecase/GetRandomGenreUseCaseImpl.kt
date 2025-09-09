package com.example.appcascaapi.domain.usecase

import com.example.appcascaapi.data.repository.GenreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomGenreUseCaseImpl @Inject constructor(
    private val genreRepository: GenreRepository
) : GetRandomGenreUseCase {

    override suspend operator fun invoke(): Flow<Result<String>> {
        return genreRepository.getGenre()
    }
}
