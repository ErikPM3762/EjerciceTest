package com.example.ejercicetest

import android.app.Application
import com.example.ejercicetest.data.module.DataSourceModule
import com.example.ejercicetest.data.network.NetworkModule
import com.example.ejercicetest.presentation.di.ApplicationComponent
import com.example.ejercicetest.presentation.di.DaggerApplicationComponent
import com.example.ejercicetest.presentation.di.module.ApplicationModule
import dagger.internal.DaggerCollections

class App : Application() {
    companion object {
        var applicationComponent: ApplicationComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        configureDagger()
    }

    private fun configureDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .dataSourceModule(DataSourceModule())
            .networkModule(NetworkModule("https://api.chucknorris.io/"))
            .build()
    }
}