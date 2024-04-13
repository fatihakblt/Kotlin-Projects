package com.fatihakbulut.retrofitkullanimi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Bu sınıf sayesinde baseUrl ve json parse işlemini gerçekleştirdik.
class RetrofitClient {

    companion object{
        fun getClient(baseUrl:String):Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}