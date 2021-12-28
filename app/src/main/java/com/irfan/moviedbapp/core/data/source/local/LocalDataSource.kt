package com.irfan.moviedbapp.core.data.source.local

import com.irfan.moviedbapp.core.data.source.local.entity.MovieEntity
import com.irfan.moviedbapp.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    suspend fun insertMovies(moviesList: List<MovieEntity>) = movieDao.insertMovies(moviesList)

}