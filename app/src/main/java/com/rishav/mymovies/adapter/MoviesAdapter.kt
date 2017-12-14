package com.rishav.mymovies.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rishav.mymovies.R
import com.rishav.mymovies.model.Results
import com.rishav.mymovies.util.ApiConstants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movies_list_row.view.*

/**
 * Created by Rishab on 12/14/2017.
 */
class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.RecyclerViewHolder>() {
    private lateinit var context: Context
    private lateinit var resultsList: List<Results>

    constructor(context: Context, resultsList: List<Results>): this(){
        this.context = context
        this.resultsList = resultsList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_movies_list_row, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val results = resultsList.get(position)
        holder.textTitle?.text = results.title
        holder.textOverview?.text = results.overview
        holder.textReleaseDate?.text = results.releaseDate
        Picasso.with(context)
                .load(ApiConstants.imageBaseUrl + results.posterPath)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var resultsList: List<Results> = ArrayList() //why is this done ??
//        var textTitle: TextView
//        var textOverview: TextView
//        var textReleaseDate: TextView
//        var image: ImageView
//
//        init {
////            this.resultsList = resultsList
//            textTitle = view.textTitle
//            textOverview = view.findViewById<TextView>(R.id.textOverview)
//            textReleaseDate = view.findViewById<TextView>(R.id.textReleaseDate)
//            image = view.findViewById<ImageView>(R.id.image)
//        }

        var textTitle = view.textTitle
        var textOverview = view.textOverview
        var textReleaseDate = view.textReleaseDate
        var image = view.image
    }
}