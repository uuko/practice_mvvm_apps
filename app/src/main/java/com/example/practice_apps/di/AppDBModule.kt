package com.example.practice_apps.di

import android.app.Application
import androidx.room.Room
import com.example.practice_apps.db.UserDatabase
import com.example.practice_apps.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDBModule {
    @Singleton
    @Provides
    fun provideAppDatabase(application: Application) = Room.databaseBuilder(
        application.applicationContext,
        UserDatabase::class.java,
        DATABASE_NAME
    ).allowMainThreadQueries().build()
}