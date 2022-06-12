package com.example.practice_apps.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice_apps.R
import com.example.practice_apps.databinding.FragmentHomeBinding
import com.example.practice_apps.ui.base.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
// */
//BaseFragment<FragmentSplashBinding, SplashViewModel>
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override var getLayoutId: Int = R.layout.fragment_home
    override var getViewModel: Class<HomeViewModel> = HomeViewModel::class.java


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewBinding.viewModel=mViewModel
//        mViewBinding.lifecycleOwner=this
    }
}