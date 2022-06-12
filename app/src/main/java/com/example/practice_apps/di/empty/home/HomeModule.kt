package com.example.practice_apps.di.empty.home

import com.example.practice_apps.ui.home.HomeRepository
import com.example.practice_apps.util.APIService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object HomeModule {
//api
    @Singleton
    @Provides
    fun provideHomeRepository(
        api: APIService
    ) = HomeRepository()
}