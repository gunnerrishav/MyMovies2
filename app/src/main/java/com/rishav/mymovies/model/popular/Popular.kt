package com.rishav.mymovies.model.popular

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/14/2017.
 */
data class Popular(
        @SerializedName("page")
        var page: Int?,

        @SerializedName("total_results")
        var totalResults: Int?,

        @SerializedName("total_pages")
        var totalPages: Int?,

        @SerializedName("results")
        var results: List<Results>?
) {
}