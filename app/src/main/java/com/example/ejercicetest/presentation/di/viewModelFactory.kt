package com.example.ejercicetest.presentation.di

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.ejercicetest.domain.repository.ChuckNorrisRepository
import com.example.ejercicetest.presentation.ui.ChuckNorrisViewModel

class viewModelFactory (
    private val core: ChuckNorrisRepository,
    owner : SavedStateRegistryOwner,
    defaultArgs : Bundle?
        ) :
        AbstractSavedStateViewModelFactory(owner,defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
      val viewModel : ViewModel = if (modelClass == ChuckNorrisViewModel::class.java) {
          ChuckNorrisViewModel(core)
      } else {
          throw RuntimeException("Unsupported view model class: $modelClass")
      }
        return viewModel as T
    }

}