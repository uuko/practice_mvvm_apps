package com.example.practice_apps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice_apps.R
import com.example.practice_apps.databinding.ActivityEmptyBinding
import com.example.practice_apps.ui.base.BaseActivity
import com.example.practice_apps.util.AnalyticsLogger
import javax.inject.Inject

class EmptyActivity : BaseActivity<ActivityEmptyBinding, EmptyViewModel>() {
    override var getLayoutId: Int = R.layout.activity_empty
    override var getViewModel: Class<EmptyViewModel> = EmptyViewModel::class.java

    @Inject
    internal lateinit var analyticsLogger: AnalyticsLogger
}