package com.rishav.mymovies.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rishav.mymovies.model.popular.Results

/**
 * Created by rishab on 04/01/18.
 */
class PopularAdapter() : RecyclerView.Adapter<PopularAdapter.RecyclerviewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.)
    }

    override fun onBindViewHolder(holder: RecyclerviewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var context: Context
    private lateinit var resultsList: List<Results>

    constructor(context: Context, resultsList: List<Results>) : this(){
        this.context = context
        this.resultsList = resultsList
    }


    class RecyclerviewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
}