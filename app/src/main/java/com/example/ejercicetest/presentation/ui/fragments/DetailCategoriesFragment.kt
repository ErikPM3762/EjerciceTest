package com.example.ejercicetest.presentation.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.Person.fromBundle
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.ejercicetest.R
import com.example.ejercicetest.databinding.FragmentDetailCategoriesBinding
import com.example.ejercicetest.presentation.common.viewBinding
import com.example.ejercicetest.presentation.ui.ChuckNorrisViewModel
import com.example.ejercicetest.utils.Event


class DetailCategoriesFragment : Fragment() {



    private val detailViewModel by activityViewModels<ChuckNorrisViewModel>()
    private val binding by viewBinding(FragmentDetailCategoriesBinding::bind)
    lateinit var idDetail :String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_categories, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            idDetail = DetailCategoriesFragmentArgs.fromBundle(it).idCategories
        }
        applyBinding()
        observeEvents()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun applyBinding() {
        with(binding) {
            detailViewModel.getListDetails(idDetail)
        }
    }

    private fun observeEvents() {
        detailViewModel.details.observe(viewLifecycleOwner, Event.EventObserver {
           /* Glide.with(requireActivity())
                .load(it.icon_url)
                .into(binding.imageDetail)*/
            //Las imagenes llegan vacias por lo cual se pone una arcordeada
            binding.imageDetail.setImageDrawable(resources.getDrawable(R.drawable.che_famiglia___questa_family_05_1))
            binding.createdAt.setText(it.result.get(0).created_at)
            binding.value.setText(it.result.get(0).value)

        })
    }


}