package com.example.ejercicetest.presentation.di

import com.example.ejercicetest.MainActivity
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class])
interface ActivitiesComponent {
    fun inject(taget: MainActivity)
}