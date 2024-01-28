package com.demo.project.module.movies.data.repository

import com.demo.project.base.Result
import com.demo.project.base.BaseRepository
import com.demo.project.module.movies.data.model.Movies
import com.demo.project.module.movies.data.remote.ApiService
import com.demo.project.module.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val apiCall : ApiService
) : BaseRepository(), MovieRepository {
    override suspend fun getMovies(): Flow<Result<Movies>> = safeApiCall {
        apiCall.getMoviesList()
    }
}