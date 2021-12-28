package com.irfan.moviedbapp.core.utils

import com.irfan.moviedbapp.core.data.source.local.entity.MovieEntity
import com.irfan.moviedbapp.core.data.source.remote.response.MovieResponse
import com.irfan.moviedbapp.core.domain.model.Movie

object DataMapper {

    fun mapResponsesToEntities(input: List<MovieResponse?>?): List<MovieEntity> {
        val moviesList = ArrayList<MovieEntity>()

        input?.map {
            val movie = MovieEntity(
                it?.id!!,
                it.title!!,
                it.overview!!,
                it.originalLanguage!!,
                it.releaseDate!!,
                it.voteAverage!!,
                it.posterPath!!
            )
            moviesList.add(movie)
        }

        return moviesList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                title = it.title,
                description = it.description,
                originalLanguage = it.originalLanguage,
                releaseYear = it.releaseYear,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath
            )
        }

    fun mapDomainToEntity(input: Movie) =
        MovieEntity(
            movieId = input.movieId,
            title = input.title,
            description = input.description,
            originalLanguage = input.originalLanguage,
            releaseYear = input.releaseYear,
            voteAverage = input.voteAverage,
            posterPath = input.posterPath
        )

}