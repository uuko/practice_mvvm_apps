package com.example.practice_apps.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.practice_apps.di.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var mViewBinding: T
    private lateinit var mViewModel: VM

    abstract var getLayoutId: Int
    abstract var getViewModel: Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Set View Binding & View Model
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId)
        mViewModel = ViewModelProvider(this, factory)[getViewModel]

        setContentView(mViewBinding.root)
    }
}