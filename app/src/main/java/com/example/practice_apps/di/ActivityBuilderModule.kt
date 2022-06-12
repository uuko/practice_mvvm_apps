package com.example.practice_apps.di

import com.example.practice_apps.di.empty.EmpModule
import com.example.practice_apps.di.empty.EmpViewModelModule
import com.example.practice_apps.di.empty.EmptyActivityBuilderModule
import com.example.practice_apps.ui.EmptyActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilderModule {

    @AnalyticsScope
    @ContributesAndroidInjector(
        modules = [
            EmptyActivityBuilderModule::class,
            EmpViewModelModule::class,
            EmpModule::class,
        ]
    )
    abstract fun contributeEmptyActivity(): EmptyActivity

}