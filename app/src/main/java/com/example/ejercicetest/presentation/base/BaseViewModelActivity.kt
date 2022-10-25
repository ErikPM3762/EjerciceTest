package com.example.ejercicetest.presentation.base


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicetest.presentation.ui.BaseViewModel
import com.example.ejercicetest.utils.Event


abstract class BaseViewModelActivity<T : BaseViewModel> : AppCompatActivity() {


    protected abstract val baseViewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEvents()
    }

    private fun observeEvents() {
        baseViewModel.showLoading.observe(this, Event.EventObserver {
            showLoadingDialog()
        })
        baseViewModel.hideLoading.observe(this, Event.EventObserver {
            hideLoadingDialog()
        })
    }

    private fun showLoadingDialog() {
        //Aqui pondre cualquier loading dependiendo del diseño
    }

    private fun hideLoadingDialog() {
        //Aqui lo oculto
    }

}