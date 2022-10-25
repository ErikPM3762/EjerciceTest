package com.example.ejercicetest.presentation.di;


import com.example.ejercicetest.data.module.DataSourceModule;
import com.example.ejercicetest.data.network.NetworkModule;
import com.example.ejercicetest.domain.repository.ChuckNorrisRepository;
import com.example.ejercicetest.presentation.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class, DataSourceModule.class})
public interface ApplicationComponent {
    ChuckNorrisRepository provideChuckNorriesRepository();
}
