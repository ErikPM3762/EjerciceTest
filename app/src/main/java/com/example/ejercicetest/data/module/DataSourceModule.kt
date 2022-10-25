package com.example.ejercicetest.data.module

import com.example.ejercicetest.data.ChuckNorriesRepository
import com.example.ejercicetest.domain.repository.ChuckNorrisRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Singleton
    @Provides
    fun provideChuckRepository(repository: ChuckNorriesRepository):ChuckNorrisRepository{return repository}
}