package com.demo.project.module.movies.presentation

sealed class MovieNavigationItems(
    val route: String
) {
    object MovieList : MovieNavigationItems("movielist")
    object MovieDetails : MovieNavigationItems("movieDetails")
}