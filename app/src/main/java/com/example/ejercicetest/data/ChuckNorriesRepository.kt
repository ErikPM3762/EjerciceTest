package com.example.ejercicetest.data

import com.example.ejercicetest.data.model.ListDetailsResponse
import com.example.ejercicetest.domain.repository.ChuckNorrisRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChuckNorriesRepository
    @Inject
    constructor(
        private val api: ServiceApi,
    ) : ChuckNorrisRepository {

        override fun getCategories(): Single<ArrayList<String>> {
            return api.getListCategories().map { serviceResponse ->
                val response = serviceResponse.body()
                return@map response
            }
        }

        override fun getDetails(idDetail: String): Single<ListDetailsResponse> {
            return api.getListDetails(idDetail).map { serviceResponse ->
                val response = serviceResponse.body()
                return@map response
            }
        }


    }