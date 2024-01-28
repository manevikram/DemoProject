package com.demo.project.module.movies.domain.usecases

import com.demo.project.base.Result
import com.demo.project.base.map
import com.demo.project.module.movies.domain.mapper.MovieMapper
import com.demo.project.module.movies.domain.model.MovieUiModel
import com.demo.project.module.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) {
    suspend fun getMovies() : Flow<Result<List<MovieUiModel>?>> {
        return movieRepository.getMovies().map { result ->
            result.map {
                movieMapper.mapFrom(it)
            }
        }
    }
}