package com.demo.project.module.movies.domain.mapper

import com.demo.project.base.Mapper
import com.demo.project.module.movies.data.model.Movies
import com.demo.project.module.movies.domain.model.MovieUiModel
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<Movies?, List<MovieUiModel>?> {

    override fun mapFrom(from: Movies?): List<MovieUiModel>? {
        return from?.results?.map {
            MovieUiModel(
                Movies.Results(
                    id = it?.id,
                    original_title = it?.original_title,
                    overview = it?.overview,
                    poster_path = it?.poster_path,
                    vote_average = it?.vote_average
                )
            )
        }
    }

}