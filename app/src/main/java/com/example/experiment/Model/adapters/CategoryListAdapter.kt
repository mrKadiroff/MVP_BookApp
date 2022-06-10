package com.example.experiment.Model.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.experiment.Model.allcategories.Result
import com.example.experiment.Model.category.Book
import com.example.experiment.databinding.CategoriesItemBinding
import com.example.experiment.databinding.TrendingItemBinding
import com.squareup.picasso.Picasso

class CategoryListAdapter (var list: List<Result>) : RecyclerView.Adapter<CategoryListAdapter.Vh>() {

    inner class Vh(var malumotItemBinding: CategoriesItemBinding) :
        RecyclerView.ViewHolder(malumotItemBinding.root) {

        fun onBind(malumotlar: Result, position: Int) {
            malumotItemBinding.categoriesItemTv.text = malumotlar.display_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(CategoriesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


}