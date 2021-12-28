package com.irfan.moviedbapp.core.domain.usecase

import com.irfan.moviedbapp.core.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovies() = movieRepository.getAllMovies()
}