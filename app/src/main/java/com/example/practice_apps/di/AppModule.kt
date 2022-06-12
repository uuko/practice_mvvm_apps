package com.example.practice_apps.di

import com.example.practice_apps.util.APIService
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable? {
        return CompositeDisposable()
    }


}