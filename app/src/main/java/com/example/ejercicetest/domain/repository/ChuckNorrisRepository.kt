package com.example.ejercicetest.domain.repository

import com.example.ejercicetest.data.model.DetailsInfo
import com.example.ejercicetest.data.model.ListDetailsResponse
import io.reactivex.Single

interface ChuckNorrisRepository {
    fun getCategories(): Single<ArrayList<String>>
    fun getDetails(idDetail: String): Single<ListDetailsResponse>
}