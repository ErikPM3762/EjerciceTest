package com.example.ejercicetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicetest.databinding.ActivityMainBinding
import com.example.ejercicetest.presentation.base.BaseViewModelActivity
import com.example.ejercicetest.presentation.ui.ChuckNorrisViewModel

class MainActivity(override val baseViewModel: ChuckNorrisViewModel) : BaseViewModelActivity<ChuckNorrisViewModel>() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}