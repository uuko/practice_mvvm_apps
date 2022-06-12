package com.example.practice_apps.di.empty

import androidx.lifecycle.ViewModel
import com.example.practice_apps.di.viewmodel.ViewModelKey
import com.example.practice_apps.ui.EmptyViewModel
import com.example.practice_apps.ui.home.HomeViewModel
import com.example.practice_apps.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class EmpViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EmptyViewModel::class)
    abstract fun bindEmpViewModel(empViewModel: EmptyViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(empViewModel: SplashViewModel): ViewModel

    //    HomeViewModel
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(empViewModel: HomeViewModel): ViewModel
}