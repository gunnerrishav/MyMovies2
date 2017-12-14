package com.rishav.mymovies.network

import com.rishav.mymovies.util.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Rishab on 12/14/2017.
 */
class RetrofitHelper{

    private lateinit var apiService: ApiService

    fun getApiService(): ApiService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConstants.baseUrl)
                .build()
        apiService = retrofit.create(ApiService::class.java)
        return apiService
    }
}