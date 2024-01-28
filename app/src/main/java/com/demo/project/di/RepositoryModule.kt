package com.demo.project.di

import com.demo.project.module.movies.data.repository.MoviesRepositoryImpl
import com.demo.project.module.movies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideMovieRepository(
        movieRepositoryImpl : MoviesRepositoryImpl
    ) : MovieRepository
}