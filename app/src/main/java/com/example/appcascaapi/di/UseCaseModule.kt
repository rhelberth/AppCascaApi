package com.example.appcascaapi.di

import com.example.appcascaapi.domain.usecase.GetRandomGenreUseCase
import com.example.appcascaapi.domain.usecase.GetRandomGenreUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class) // UseCases are often scoped to ViewModels
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped // Scope the use case to the ViewModel's lifecycle
    abstract fun bindGetRandomGenreUseCase(impl: GetRandomGenreUseCaseImpl): GetRandomGenreUseCase
}
