package com.example.experiment.presenter

import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.MyResource
import com.example.experiment.Model.allcategories.AllCategory
import com.example.experiment.Model.author.AuthorResult
import com.example.experiment.Model.bessellerResult.BessellerResult
import com.example.experiment.Model.category.CategoryResult
import com.example.experiment.Model.title.TitleResult

class Presenter(
    private val mainView: Contacts.View,
    private val model: Contacts.Model
) : Contacts.Presenter, Contacts.Model.ApiGetBooks {
    override fun getBessellerBooks(res: MyResource<AllBooksResult>) {
        mainView.showBessellerBooks(res)
    }


    override fun onCreateStart() {
        model.updateUiFirst(this)
    }

    override fun getCategoryBooks(res: MyResource<CategoryResult>) {
        mainView.showCategoryBooks(res)
    }

    override fun onSearchCategory(word: String) {
        model.updateCategory(this,word)
    }


    override fun getTitleBooks(res: MyResource<TitleResult>) {
        mainView.showTitleBooks(res)
    }

    override fun onSearchTitle(word: String) {
        model.updateTitle(this,word)
    }

    override fun getAuthorBooks(res: MyResource<AuthorResult>) {
        mainView.showAuthorBooks(res)
    }

    override fun getAllCategory(res: MyResource<AllCategory>) {
        mainView.showAllCategory(res)
    }


    override fun onSearchAuthor(word: String) {
        model.updateAuthor(this,word)
    }

    override fun onCategoryStart() {
        model.updateAllCategory(this)
    }


}