package com.example.ejercicetest.presentation.ui.fragments.adapter

import android.content.Context
import android.hardware.biometrics.BiometricManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicetest.R

class ListCategoriesAdapter(context:Context) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var data : ArrayList<String> = arrayListOf()
    val TYPE_VIEW : Int = 0



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
     var view: View?
     view = getInflatedView(parent, R.layout.items_list_categories)
        return CategoriesViewHolder(view!!)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       var viewType : Int = getItemViewType(position)
        when(viewType) {
            TYPE_VIEW -> {
                val n : CategoriesViewHolder = holder as CategoriesViewHolder
                n.categorie.setText(data.get(position))
                n.categorie.setOnClickListener {  }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun getInflatedView(parent: ViewGroup, resourceLayout: Int): View? {
        return LayoutInflater
            .from(parent.context)
            .inflate(resourceLayout, parent, false)
    }

    class CategoriesViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var categorie : TextView

        init {
            categorie = itemView.findViewById(R.id.nameCtegorie)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE_VIEW
    }


}