package com.example.experiment.Model.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.AllBooks.Book
import com.example.experiment.databinding.TrendingItemBinding
import com.squareup.picasso.Picasso

class AllBookAdapter  (var list: List<Book>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<AllBookAdapter.Vh>() {

    inner class Vh(var malumotItemBinding: TrendingItemBinding) :
        RecyclerView.ViewHolder(malumotItemBinding.root) {

        fun onBind(malumotlar: Book,position: Int) {
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
        fun onItemClick(malumotlar: Book)
    }
}