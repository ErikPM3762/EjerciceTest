package com.example.ejercicetest.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicetest.R
import com.example.ejercicetest.databinding.FragmentListCategoriesBinding
import com.example.ejercicetest.presentation.common.viewBinding
import com.example.ejercicetest.presentation.ui.ChuckNorrisViewModel
import com.example.ejercicetest.presentation.ui.fragments.adapter.ListCategoriesAdapter
import com.example.ejercicetest.utils.Event


class ListCategoriesFragment : Fragment() {

    private val binding by viewBinding(FragmentListCategoriesBinding::bind)
    private val chuckViewModel by activityViewModels<ChuckNorrisViewModel>()
    lateinit var adapter : ListCategoriesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ListCategoriesAdapter(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyBinding()
        observeEvents()

    }

    private fun applyBinding() {
        with(binding){
            listCategories.adapter = adapter
            listCategories.layoutManager = LinearLayoutManager(context)
            chuckViewModel.getListCategories()
        }
    }

    private fun observeEvents(){
        chuckViewModel.categories.observe(viewLifecycleOwner,Event.EventObserver {
            adapter.data= it
            adapter.notifyDataSetChanged()
        })
    }

}