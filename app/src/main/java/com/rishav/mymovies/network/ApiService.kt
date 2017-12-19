package com.rishav.mymovies.network

import com.rishav.mymovies.model.Movies
import com.rishav.mymovies.model.popular.Popular
import com.rishav.mymovies.util.ApiConstants
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Rishab on 12/14/2017.
 */
interface ApiService {
    @GET(ApiConstants.movieList)
    fun getMovieList() : Call<Movies>

    @GET(ApiConstants.popularList)
    fun getPopularList() : Call<Popular>
}