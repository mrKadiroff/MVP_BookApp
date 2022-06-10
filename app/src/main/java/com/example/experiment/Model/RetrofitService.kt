package com.example.experiment.Model

import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.RetrofitClient.API_KEY
import com.example.experiment.Model.allcategories.AllCategory
import com.example.experiment.Model.author.AuthorResult
import com.example.experiment.Model.bessellerResult.BessellerResult
import com.example.experiment.Model.category.CategoryResult
import com.example.experiment.Model.title.TitleResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


    // search by title
    @GET("reviews.json")
    suspend fun getDataByTitle(
        @Query("title") title:String,
        @Query("api-key") apikey:String = API_KEY
    ):TitleResult


    // search by author name
    @GET("reviews.json")
    suspend fun getDataByAuthor(
        @Query("author") author:String,
        @Query("api-key") apikey:String = API_KEY
    ): AuthorResult


    // search by category name
    @GET("lists/current/{path}.json")
    suspend fun getDataByCategory(
        @Path("path") path: String,
        @Query("api-key") apikey:String = API_KEY
    ): CategoryResult

    // search all category
    @GET("lists/names")
    suspend fun getCategory(
        @Query("api-key") apikey:String = API_KEY
    ): AllCategory



    // search besselser books
    @GET("lists/full-overview.json")
    suspend fun getDataByBestseller(
        @Query("api-key") apikey:String = API_KEY
    ): AllBooksResult


}