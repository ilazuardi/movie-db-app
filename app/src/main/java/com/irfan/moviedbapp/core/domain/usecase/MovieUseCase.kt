package com.irfan.moviedbapp.core.domain.usecase

import com.irfan.moviedbapp.core.data.Resource
import com.irfan.moviedbapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

}