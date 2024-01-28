package com.demo.project.module.movies.domain.repository

import com.demo.project.base.Result
import com.demo.project.module.movies.data.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies() : Flow<Result<Movies>>
}