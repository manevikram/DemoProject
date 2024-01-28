package com.demo.project.module.movies.presentation

import com.demo.project.module.movies.domain.model.MovieUiModel

data class MovieState(
    val data : List<MovieUiModel>? = emptyList(),
    val error : String = "",
    val isLoading : Boolean = false
)