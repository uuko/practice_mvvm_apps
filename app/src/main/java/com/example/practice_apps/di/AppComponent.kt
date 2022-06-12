package com.example.practice_apps.di

import android.app.Application
import com.example.practice_apps.App
import com.example.practice_apps.util.APIService
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        APIModule::class,
        AppDBModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent


    }


}
