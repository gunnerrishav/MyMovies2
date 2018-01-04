package com.rishav.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rishav.mymovies.model.popular.Popular
import com.rishav.mymovies.model.popular.Results
import com.rishav.mymovies.network.RetrofitHelper
import kotlinx.android.synthetic.main.activity_popular.*
import retrofit2.Call
import retrofit2.Response

class PopularActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular)

        getData()
    }

    private fun getData() {
        val retfitHelper = RetrofitHelper()

        val popularCall = retfitHelper.getApiService().getPopularList()
        popularCall.enqueue(object : retrofit2.Callback<Popular> {
            override fun onResponse(call: Call<Popular>?, response: Response<Popular>) {
                if (response.isSuccessful){
                    val popular = response?.body()
                    val popularList: List<Results>? = popular?.results
                    val popularData : Int? = popular?.page
//                    Log.d("test",popularList[10].title)
                }
            }

            override fun onFailure(call: Call<Popular>?, t: Throwable?) {

            }

        })

    }
}
