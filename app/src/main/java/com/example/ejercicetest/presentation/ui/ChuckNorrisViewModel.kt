package com.example.ejercicetest.presentation.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicetest.data.model.ListDetailsResponse
import com.example.ejercicetest.domain.repository.ChuckNorrisRepository
import com.example.ejercicetest.utils.Event
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class ChuckNorrisViewModel
@Inject constructor(private val chuckNorrisRepository: ChuckNorrisRepository) : BaseViewModel() {

    private val disposable = CompositeDisposable()

    private val _categories = MutableLiveData<Event<ArrayList<String>>>()
    val categories get() = _categories

    private val _details = MutableLiveData<Event<ListDetailsResponse>>()
    val details get() = _details

    internal fun getListCategories() {
        val task = chuckNorrisRepository.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val suscriber = task.subscribe({
            onSussesfulList(it)
        },{

        })

        disposable.add(suscriber)

    }


    internal fun getListDetails(idDetail: String) {
        val task = chuckNorrisRepository.getDetails(idDetail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val subscriber = task.subscribe({
            onSussesfulListSDetails(it)
        }, {

        })
        disposable.add(subscriber)
    }

    private fun onSussesfulList(data : ArrayList<String>){
        _categories.postValue(Event(data))
    }


    private fun onSussesfulListSDetails(data : ListDetailsResponse){
        _details.postValue(Event(data))
    }
}