package com.irfan.moviedbapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.irfan.moviedbapp.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel() {

    val movie = movieUseCase.getAllMovies().asLiveData()

}