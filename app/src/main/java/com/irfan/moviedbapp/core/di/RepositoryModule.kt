package com.irfan.moviedbapp.core.di

import com.irfan.moviedbapp.core.data.MovieRepository
import com.irfan.moviedbapp.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository

}