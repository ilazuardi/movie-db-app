package com.irfan.moviedbapp

import android.app.Application
import com.irfan.moviedbapp.core.di.CoreComponent
import com.irfan.moviedbapp.core.di.DaggerCoreComponent
import com.irfan.moviedbapp.di.AppComponent
import com.irfan.moviedbapp.di.DaggerAppComponent

class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

}