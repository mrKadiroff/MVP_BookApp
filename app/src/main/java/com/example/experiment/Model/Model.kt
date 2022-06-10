package com.example.experiment.Model

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.experiment.Model.bessellerResult.BessellerResult
import com.example.experiment.presenter.Contacts

class Model(var viewModelStoreOwner: ViewModelStoreOwner, var lifecycleOwner: LifecycleOwner) :
      Contacts.Model{
    val myBookViewModel: MyBookViewModel =
        ViewModelProvider(viewModelStoreOwner).get(MyBookViewModel::class.java)
    var list = ArrayList<BessellerResult>()

    override fun updateUiFirst(apiGetBooks: Contacts.Model.ApiGetBooks) {
        myBookViewModel.getMyBesseller().observe(lifecycleOwner) {
            when(it.status){
                MyStatus.SUCCESS->{

                }
            }
            apiGetBooks.getBessellerBooks(it)
        }

    }

    override fun updateCategory(apiGetBooks: Contacts.Model.ApiGetBooks, category: String) {
        myBookViewModel.getMyCategory(category).observe(lifecycleOwner){
            when(it.status){
                MyStatus.SUCCESS->{

                }
            }
            apiGetBooks.getCategoryBooks(it)
        }
    }

    override fun updateTitle(apiGetBooks: Contacts.Model.ApiGetBooks, title: String) {
        myBookViewModel.getMyTitle(title).observe(lifecycleOwner){
            when(it.status){
                MyStatus.SUCCESS->{

                }
            }
            apiGetBooks.getTitleBooks(it)
        }
    }

    override fun updateAuthor(apiGetBooks: Contacts.Model.ApiGetBooks, author: String) {
        myBookViewModel.getMyAuthor(author).observe(lifecycleOwner){
            when(it.status){
                MyStatus.SUCCESS->{

                }
            }
            apiGetBooks.getAuthorBooks(it)
        }
    }

    override fun updateAllCategory(apiGetBooks: Contacts.Model.ApiGetBooks) {
        myBookViewModel.getMyAllCategory().observe(lifecycleOwner){
            when(it.status){
                MyStatus.SUCCESS->{

                }
            }
            apiGetBooks.getAllCategory(it)
        }
    }


}