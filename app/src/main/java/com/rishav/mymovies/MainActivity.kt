package com.rishav.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.rishav.mymovies.adapter.MoviesAdapter
import com.rishav.mymovies.model.Movies
import com.rishav.mymovies.model.Results
import com.rishav.mymovies.network.RetrofitHelper
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var resultsList: ArrayList<Results>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        getData()
    }

    private fun initRecyclerView() {
        recyclerviewMoviesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerviewMoviesList.setHasFixedSize(true)
        recyclerviewMoviesList.isNestedScrollingEnabled = true
        resultsList = ArrayList()
        moviesAdapter = MoviesAdapter(applicationContext, resultsList)
        recyclerviewMoviesList.adapter = moviesAdapter
    }

//    //Api call
//    private fun getData() {
//        val retrofitHelper = RetrofitHelper()
//
//        val moviesCall = retrofitHelper.getApiService().getMovieList()
//        moviesCall.enqueue(object : retrofit2.Callback<Movies> {
//            override fun onResponse(call: Call<Movies>?, response: Response<Movies>) {
//                if (response.isSuccessful){
//                    val movies = response.body()
//                    val resultsList: List<Results>? = movies?.results
//                    //to populate recylerview with resultsList
//                    populateRecyclerView(resultsList)
//                }else{
//                    Toast.makeText(this@MainActivity, "Oops! Something went wrong!",Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<Movies>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Net chaina",Toast.LENGTH_SHORT).show()
//            }
//
//        })
//    }

    //Api call
    private fun getData() {
        val retrofitHelper = RetrofitHelper()

        val moviesCall = retrofitHelper.getApiService().getMovieList()
        moviesCall.enqueue(object : retrofit2.Callback<Movies> {
            override fun onResponse(call: Call<Movies>?, response: Response<Movies>) {
                if (response.isSuccessful) {
                    val movies = response.body()
                    //save movies db to realm
                    saveToRealm(movies)
                    val resultsList: List<Results>? = movies?.results
                    //to populate recylerview with resultsList
                    populateRecyclerView(resultsList)
                } else {
                    //get data from realm
                    val movies: Movies? = getDataFromRealm()
                    if (movies != null) {
                        val resultsList = movies.results
                        populateRecyclerView(resultsList)
                    } else {
                        Toast.makeText(this@MainActivity, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                //get data from realm
                val movies: Movies? = getDataFromRealm()
                if (movies != null) {
                    val resultsList = movies.results
                    populateRecyclerView(resultsList)
                } else {
                    Toast.makeText(this@MainActivity, "Net chaina", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private fun populateRecyclerView(resultList: List<Results>?) {
        if (resultList != null) {
            this.resultsList.clear()
            this.resultsList.addAll(resultList) //api bata ayeko result adapter ma pass gareko list ma rakheko
            moviesAdapter.notifyDataSetChanged()
        }
    }

    private fun saveToRealm(movies: Movies?) {
        if (movies != null) {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(movies)
            realm.commitTransaction()
            realm.close()
        }
    }

    private fun getDataFromRealm(): Movies? {
        val realm = Realm.getDefaultInstance()
        val movies = realm.where(Movies::class.java).findFirst()
        return movies
    }
}

