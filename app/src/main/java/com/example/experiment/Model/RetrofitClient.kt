package com.example.experiment.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"
    const val API_KEY = "beKOJAq1sjYHYp2raykgNMvjzHt4npjr"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun retrofitService() :RetrofitService{
        return getRetrofit().create(RetrofitService::class.java)
    }

}