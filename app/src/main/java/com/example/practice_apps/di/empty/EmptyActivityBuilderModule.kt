package com.example.practice_apps.di.empty

import com.example.practice_apps.di.empty.home.HomeModule
import com.example.practice_apps.di.empty.home.HomeScope
import com.example.practice_apps.ui.home.HomeFragment
import com.example.practice_apps.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class EmptyActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment():SplashFragment

    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            HomeModule::class
        ]
    )
    abstract fun contributeHomeFragment(): HomeFragment
}