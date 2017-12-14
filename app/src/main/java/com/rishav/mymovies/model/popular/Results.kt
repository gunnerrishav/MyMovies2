package com.rishav.mymovies.model.popular

import com.google.gson.annotations.SerializedName

/**
 * Created by Rishab on 12/14/2017.
 */
data class Results(
        @SerializedName("vote_count")
        var voteCount: Int?,

        @SerializedName("id")
        var id: Int?,

        @SerializedName("video")
        var video: Boolean?,

        @SerializedName("vote_average")
        var voteAverage: Float?,

        @SerializedName("title")
        var title: String?,

        @SerializedName("popularity")
        var popularity: Float?,

        @SerializedName("poster_path")
        var posterPath: String?,

        @SerializedName("original_language")
        var originalLanguage: String?,

        @SerializedName("original_title")
        var originalTitle: String?,

        @SerializedName("genre_ids")
        var genreIds: List<Int>?,

        @SerializedName("backdrop_path")
        var backdropPath: String?,

        @SerializedName("adult")
        var adult: Boolean?,

        @SerializedName("overview")
        var overview: String?,

        @SerializedName("release_date")
        var releaseDate: String?
) {
}