package com.irfan.moviedbapp.core.di

import android.content.Context
import com.irfan.moviedbapp.core.domain.repository.IMovieRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): IMovieRepository

}