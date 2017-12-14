package com.rishav.mymovies.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Rishab on 12/14/2017.
 */

//data class Movies(
//        @SerializedName("results")
//        var results: List<Results>?,
//
//        @SerializedName("page")
//        var page: Int?,
//
//        @SerializedName("total_results")
//        var totalResults: Int?,
//
//        @SerializedName("dates")
//        var dates: Dates?,
//
//        @SerializedName("total_pages")
//        var totalPages: Int?
//)


open class Movies: RealmObject() {
    @SerializedName("results")
    var results: RealmList<Results>? = null

    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("dates")
    var dates: Dates? = null

    @PrimaryKey
    @SerializedName("total_pages")
    var totalPages: Int? = null
}