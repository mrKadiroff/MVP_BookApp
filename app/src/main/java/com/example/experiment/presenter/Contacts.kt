package com.example.experiment.presenter

import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.MyResource
import com.example.experiment.Model.allcategories.AllCategory
import com.example.experiment.Model.author.AuthorResult
import com.example.experiment.Model.bessellerResult.BessellerResult
import com.example.experiment.Model.category.CategoryResult
import com.example.experiment.Model.title.TitleResult

interface Contacts {

    //update ui
    interface View {
        fun showBessellerBooks(res: MyResource<AllBooksResult>)
        fun showCategoryBooks(res: MyResource<CategoryResult>)
        fun showTitleBooks(res: MyResource<TitleResult>)
        fun showAuthorBooks(res: MyResource<AuthorResult>)
        fun showAllCategory(res: MyResource<AllCategory>)
    }

    interface Model {
        interface ApiGetBooks {
            fun getBessellerBooks(res: MyResource<AllBooksResult>)
            fun getCategoryBooks(res: MyResource<CategoryResult>)
            fun getTitleBooks(res: MyResource<TitleResult>)
            fun getAuthorBooks(res: MyResource<AuthorResult>)
            fun getAllCategory(res: MyResource<AllCategory>)
        }
        fun updateUiFirst(apiGetBooks: ApiGetBooks)
        fun updateCategory(apiGetBooks: ApiGetBooks,category:String)
        fun updateTitle(apiGetBooks: ApiGetBooks,title:String)
        fun updateAuthor(apiGetBooks: ApiGetBooks,author:String)
        fun updateAllCategory(apiGetBooks: ApiGetBooks)

    }

    //action user
    interface Presenter {
        fun onCreateStart()
        fun onSearchCategory(word:String)
        fun onSearchTitle(word: String)
        fun onSearchAuthor(word: String)
        fun onCategoryStart()
    }
}