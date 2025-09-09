package com.example.appcascaapi.di

// Updated imports
import com.example.appcascaapi.data.repository.GenreRepository
import com.example.appcascaapi.data.repository.GenreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) 
abstract class RepositoryModule {

    @Binds
    @Singleton
    // Updated method signature and name
    abstract fun bindGenreRepository(impl: GenreRepositoryImpl): GenreRepository
}
