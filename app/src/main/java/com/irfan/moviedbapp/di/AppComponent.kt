package com.irfan.moviedbapp.di

import com.irfan.moviedbapp.MainActivity
import com.irfan.moviedbapp.core.di.CoreComponent
import com.irfan.moviedbapp.detail.DetailActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: DetailActivity)
}