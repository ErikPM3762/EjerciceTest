package com.example.ejercicetest.presentation.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicetest.utils.Event

open class BaseViewModel : ViewModel() {
    private val _showLoading = MutableLiveData<Event<Unit>>()
    val showLoading get() = _showLoading

    private val _hideLoading = MutableLiveData<Event<Unit>>()
    val hideLoading get() = _hideLoading
}