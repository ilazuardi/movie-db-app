package com.irfan.moviedbapp.di

import com.irfan.moviedbapp.core.domain.usecase.MovieInteractor
import com.irfan.moviedbapp.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideAwesomeUseCase(movieInteractor: MovieInteractor): MovieUseCase
}