package com.irfan.moviedbapp.core.data.source.remote

import android.util.Log
import com.irfan.moviedbapp.core.data.source.remote.network.ApiResponse
import com.irfan.moviedbapp.core.data.source.remote.network.ApiService
import com.irfan.moviedbapp.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    companion object {
        private const val API_KEY = "0a90a92a5089b71074eb703ce903b7f7"
    }

    fun getAllMovies(): Flow<ApiResponse<List<MovieResponse?>?>> {
        return flow {
            try {
                val response = apiService.getListMovies(API_KEY)
                val dataArray = response.results
                if (dataArray!!.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("REMOTEDATASOURCE", "getAllMovies: $e")
            }
        }.flowOn(Dispatchers.IO)
    }

}