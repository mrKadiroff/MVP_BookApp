package com.example.experiment.Model.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.experiment.Model.author.Result
import com.example.experiment.Model.category.Book
import com.example.experiment.databinding.TrendingItemBinding
import com.example.experiment.databinding.TrendingItemdoubleBinding
import com.squareup.picasso.Picasso

class CategoryAdapter (var list: List<com.example.experiment.Model.category.Book>,var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.Vh>() {

    inner class Vh(var malumotItemBinding: TrendingItemBinding) :
        RecyclerView.ViewHolder(malumotItemBinding.root) {

        fun onBind(malumotlar: com.example.experiment.Model.category.Book, position: Int) {
            Picasso.get().load(malumotlar.book_image).into(malumotItemBinding.imageView);
            malumotItemBinding.trendingBooksText.text = malumotlar.author
            malumotItemBinding.root.setOnClickListener {
                onItemClickListener.onItemClick(malumotlar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(TrendingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


    interface OnItemClickListener{
        fun onItemClick( book: com.example.experiment.Model.category.Book)
    }

}