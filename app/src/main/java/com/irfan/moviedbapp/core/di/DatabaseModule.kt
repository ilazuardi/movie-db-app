package com.irfan.moviedbapp.core.di

import android.content.Context
import androidx.room.Room
import com.irfan.moviedbapp.core.data.source.local.room.AppDatabase
import com.irfan.moviedbapp.core.data.source.local.room.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "App.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()

}