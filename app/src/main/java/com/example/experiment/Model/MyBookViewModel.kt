package com.example.experiment.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.allcategories.AllCategory
import com.example.experiment.Model.author.AuthorResult
import com.example.experiment.Model.bessellerResult.BessellerResult
import com.example.experiment.Model.category.CategoryResult
import com.example.experiment.Model.title.TitleResult
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MyBookViewModel : ViewModel() {
    private val TAG = "MyBookViewModel"
    private val myBessellerModel = MutableLiveData<MyResource<AllBooksResult>>()
    private val myCategoryModel = MutableLiveData<MyResource<CategoryResult>>()
    private val myTitleModel = MutableLiveData<MyResource<TitleResult>>()
    private val myAuthorModel = MutableLiveData<MyResource<AuthorResult>>()
    private val myAllCategoryModel = MutableLiveData<MyResource<AllCategory>>()



    fun getMyBesseller(): LiveData<MyResource<AllBooksResult>> {
        val apiService = RetrofitClient.retrofitService()

        viewModelScope.launch {
            myBessellerModel.postValue(MyResource.loading(null))

            try {
                coroutineScope {
                    val async1 = async { apiService.getDataByBestseller() }
                    val await = async1.await()
                    myBessellerModel.postValue(MyResource.success(await))
                }
            }catch (e:Exception){
                myBessellerModel.postValue(MyResource.error(e.message, null))
            }
        }


        return myBessellerModel
    }


    fun getMyCategory(word:String): LiveData<MyResource<CategoryResult>> {
        val apiService = RetrofitClient.retrofitService()

        viewModelScope.launch {
            myCategoryModel.postValue(MyResource.loading(null))

            try {
                coroutineScope {
                    val async1 = async { apiService.getDataByCategory(word) }
                    val await = async1.await()
                    myCategoryModel.postValue(MyResource.success(await))
                }
            }catch (e:Exception){
                myCategoryModel.postValue(MyResource.error(e.message, null))
            }
        }


        return myCategoryModel
    }



    fun getMyTitle(word:String): LiveData<MyResource<TitleResult>> {
        val apiService = RetrofitClient.retrofitService()

        viewModelScope.launch {
            myTitleModel.postValue(MyResource.loading(null))

            try {
                coroutineScope {
                    val async1 = async { apiService.getDataByTitle(word) }
                    val await = async1.await()
                    myTitleModel.postValue(MyResource.success(await))
                }
            }catch (e:Exception){
                myTitleModel.postValue(MyResource.error(e.message, null))
            }
        }


        return myTitleModel
    }




    fun getMyAuthor(word:String): LiveData<MyResource<AuthorResult>> {
        val apiService = RetrofitClient.retrofitService()

        viewModelScope.launch {
            myAuthorModel.postValue(MyResource.loading(null))

            try {
                coroutineScope {
                    val async1 = async { apiService.getDataByAuthor(word) }
                    val await = async1.await()
                    myAuthorModel.postValue(MyResource.success(await))
                }
            }catch (e:Exception){
                myAuthorModel.postValue(MyResource.error(e.message, null))
            }
        }


        return myAuthorModel
    }


    fun getMyAllCategory(): LiveData<MyResource<AllCategory>> {
        val apiService = RetrofitClient.retrofitService()

        viewModelScope.launch {
            myAllCategoryModel.postValue(MyResource.loading(null))

            try {
                coroutineScope {
                    val async1 = async { apiService.getCategory() }
                    val await = async1.await()
                    myAllCategoryModel.postValue(MyResource.success(await))
                }
            }catch (e:Exception){
                myAllCategoryModel.postValue(MyResource.error(e.message, null))
            }
        }


        return myAllCategoryModel
    }



}