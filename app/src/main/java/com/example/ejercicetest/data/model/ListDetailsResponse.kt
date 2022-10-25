package com.example.ejercicetest.data.model


data class ListDetailsResponse(
    var total: Int? = 0,
    var results: ArrayList<DetailsInfo> = arrayListOf(),

)
