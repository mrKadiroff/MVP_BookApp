package com.example.experiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experiment.Model.category.Book
import com.example.experiment.databinding.ActivityMain2Binding
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {
    var book: Book? = null
    var kitob: com.example.experiment.Model.AllBooks.Book? = null
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val categroy = intent.getSerializableExtra("category")
        val book = intent.getSerializableExtra("book")

        if (categroy!=null){
            setScience()
        }

        if (book!=null){
            setBook()
        }

        binding.imageBack.setOnClickListener {
            finish()
        }


    }

    private fun setBook() {
        kitob = intent.getSerializableExtra("kitob") as com.example.experiment.Model.AllBooks.Book
        Picasso.get().load(kitob!!.book_image).into(binding.image2)
        binding.tvDisplayName1.text = kitob!!.title
        binding.tvDisplayName2.text = "by ${kitob!!.author}"
        binding.tvDesc.text = kitob!!.description
        binding.tvPrice.text = kitob!!.price
        binding.tvRating.text = kitob!!.rank.toString()
    }

    private fun setScience() {
        book = intent.getSerializableExtra("key") as Book
        Picasso.get().load(book!!.book_image).into(binding.image2);
        binding.tvDisplayName1.text = book!!.title
        binding.tvDisplayName2.text = "by ${book!!.author}"
        binding.tvDesc.text = book!!.description
        binding.tvPrice.text = book!!.price
        binding.tvRating.text = book!!.rank.toString()
    }
}