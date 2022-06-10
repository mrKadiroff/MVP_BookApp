package com.example.experiment.Model.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.AllBooks.Book
import com.example.experiment.Model.author.AuthorResult
import com.example.experiment.Model.author.Result
import com.example.experiment.databinding.TrendingItemBinding
import com.example.experiment.databinding.TrendingItemdoubleBinding
import com.squareup.picasso.Picasso

class AuthorAdapter(var list: List<Result>) : RecyclerView.Adapter<AuthorAdapter.Vh>() {

    inner class Vh(var malumotItemBinding: TrendingItemdoubleBinding) :
        RecyclerView.ViewHolder(malumotItemBinding.root) {

        fun onBind(malumotlar: Result, position: Int) {
            malumotItemBinding.avtor.text = "by ${malumotlar.book_author}"
            malumotItemBinding.heading.text = malumotlar.book_title
            malumotItemBinding.about.text = malumotlar.summary
            malumotItemBinding.price.text = malumotlar.publication_dt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(TrendingItemdoubleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


}