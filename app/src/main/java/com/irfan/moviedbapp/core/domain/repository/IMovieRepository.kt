package com.irfan.moviedbapp.core.domain.repository

import com.irfan.moviedbapp.core.data.Resource
import com.irfan.moviedbapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

}