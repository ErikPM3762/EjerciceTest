package com.example.ejercicetest.data

import android.telecom.Call
import com.example.ejercicetest.data.model.ListDetailsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("jokes/categories")
    fun getListCategories(): Single<Response<ArrayList<String>>>

    @GET("/search?query=false")
    fun getListDetails(@Query("details") details: String): Single<Response<ListDetailsResponse>>

}