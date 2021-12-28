package com.irfan.moviedbapp.core.data

import com.irfan.moviedbapp.core.data.source.local.LocalDataSource
import com.irfan.moviedbapp.core.data.source.remote.RemoteDataSource
import com.irfan.moviedbapp.core.data.source.remote.network.ApiResponse
import com.irfan.moviedbapp.core.data.source.remote.response.MovieResponse
import com.irfan.moviedbapp.core.domain.model.Movie
import com.irfan.moviedbapp.core.domain.repository.IMovieRepository
import com.irfan.moviedbapp.core.utils.AppExecutors
import com.irfan.moviedbapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {

    override fun getAllMovies(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> = localDataSource.getAllMovies().map{ DataMapper.mapEntitiesToDomain(it)}

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse?>?>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse?>?) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }
        }.asFlow()

}