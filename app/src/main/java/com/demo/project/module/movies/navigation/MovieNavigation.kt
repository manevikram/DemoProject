package com.demo.project.module.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.project.module.movies.presentation.MovieDetailScreen
import com.demo.project.module.movies.presentation.MovieListScreen
import com.demo.project.module.movies.presentation.MovieViewModel
import com.demo.project.module.movies.presentation.MovieNavigationItems

@Composable
fun MovieNavigation(
    viewModel: MovieViewModel
) {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = MovieNavigationItems.MovieList.route
    ) {
        composable(MovieNavigationItems.MovieList.route){
            MovieListScreen(viewModel = viewModel, navHostController = navHostController)
        }
        composable(MovieNavigationItems.MovieDetails.route){
            MovieDetailScreen(viewModel)
        }
    }

}