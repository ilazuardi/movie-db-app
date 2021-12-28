package com.irfan.moviedbapp.core.data.source.remote.network

import com.irfan.moviedbapp.core.data.source.remote.response.ListMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("popular")
    suspend fun getListMovies(
        @Query("api_key") api_key: String
    ): ListMoviesResponse

}