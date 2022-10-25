package com.example.ejercicetest

import android.os.Bundle
import androidx.activity.viewModels
import com.example.ejercicetest.domain.repository.ChuckNorrisRepository
import com.example.ejercicetest.presentation.base.BaseViewModelActivity
import com.example.ejercicetest.presentation.di.DaggerActivitiesComponent
import com.example.ejercicetest.presentation.ui.ChuckNorrisViewModel
import javax.inject.Inject

class MainActivity : BaseViewModelActivity<ChuckNorrisViewModel>() {

    override val baseViewModel: ChuckNorrisViewModel
        get() = chuckViewModel


    @Inject
    lateinit var core: ChuckNorrisRepository
    private val chuckViewModel by viewModels<ChuckNorrisViewModel> {
        com.example.ejercicetest.presentation.di.viewModelFactory(
            core,
            this,
            intent.extras
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjection()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initInjection() {
        val component = DaggerActivitiesComponent.builder()
            .applicationComponent(App.applicationComponent)
            .build()
        component.inject(this)
    }
}