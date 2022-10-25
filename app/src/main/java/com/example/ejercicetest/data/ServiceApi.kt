package com.example.ejercicetest.data

import android.telecom.Call
import com.example.ejercicetest.data.model.DetailsInfo
import com.example.ejercicetest.data.model.ListDetailsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("jokes/categories")
    fun getListCategories(): Single<Response<ArrayList<String>>>

    @GET("jokes/search?")
    fun getListDetails(@Query("query") details: String): Single<Response<ListDetailsResponse>>

}