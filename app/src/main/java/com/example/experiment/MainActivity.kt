package com.example.experiment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.experiment.Model.AllBooks.AllBooksResult
import com.example.experiment.Model.Model
import com.example.experiment.Model.MyResource
import com.example.experiment.Model.MyStatus
import com.example.experiment.Model.RetrofitClient
import com.example.experiment.Model.adapters.AllBookAdapter
import com.example.experiment.Model.adapters.AuthorAdapter
import com.example.experiment.Model.adapters.CategoryAdapter
import com.example.experiment.Model.adapters.CategoryListAdapter
import com.example.experiment.Model.allcategories.AllCategory
import com.example.experiment.Model.author.AuthorResult
import com.example.experiment.Model.category.Book
import com.example.experiment.Model.category.CategoryResult
import com.example.experiment.Model.title.TitleResult
import com.example.experiment.databinding.ActivityMainBinding
import com.example.experiment.presenter.Contacts
import com.example.experiment.presenter.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(),Contacts.View {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    private var presenter: Presenter? = null
    lateinit var allBookAdapter: AllBookAdapter
    lateinit var authorAdapter: AuthorAdapter
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var categoryListAdapter: CategoryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        presenter = Presenter(this, Model(this, this))
        presenter?.onCreateStart()
        presenter?.onSearchCategory("Science")
        presenter?.onCategoryStart()


       binding.editetext.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.clear.visibility = View.VISIBLE
                binding.categoriesTv.visibility = View.GONE
                binding.categoriesRV.visibility = View.GONE
                binding.trendingBooksTv.visibility = View.GONE
                binding.trendingBooksRV.visibility = View.GONE
                binding.topAuthorsRV.visibility = View.GONE
                binding.topAuthorsTv.visibility = View.GONE
                val searchvalue = binding.editetext.text.toString()
                presenter!!.onSearchTitle(searchvalue)
                return@OnEditorActionListener true
            }
            false
        })

        binding.clear.setOnClickListener {

            binding.aftorRv.visibility = View.GONE
            binding.description.visibility = View.GONE
            binding.title.visibility = View.GONE
            binding.titkeImage.visibility = View.GONE
            binding.clear.visibility = View.GONE
            binding.editetext.setText("")




            binding.categoriesTv.visibility = View.VISIBLE
            binding.categoriesRV.visibility = View.VISIBLE
            binding.trendingBooksTv.visibility = View.VISIBLE
            binding.trendingBooksRV.visibility = View.VISIBLE
            binding.topAuthorsRV.visibility = View.VISIBLE
            binding.topAuthorsTv.visibility = View.VISIBLE
        }



    }

    override fun showBessellerBooks(res: MyResource<AllBooksResult>) {
        when (res.status) {
            MyStatus.SUCCESS -> {
                val l = res.data
                allBookAdapter = AllBookAdapter(res.data!!.results.lists[0].books,object :AllBookAdapter.OnItemClickListener{
                    override fun onItemClick(malumotlar: com.example.experiment.Model.AllBooks.Book) {
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra("book","book")
                        intent.putExtra("kitob",malumotlar)
                        startActivity(intent)
                    }


                })

                binding.topAuthorsRV.adapter = allBookAdapter


//                Log.d(TAG, "showTrendingBooks: ${l}")
//                Toast.makeText(this, l.toString(), Toast.LENGTH_SHORT).show()

            }
            MyStatus.ERROR -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

            }
            MyStatus.LOADING->{

            }
        }
    }

    override fun showCategoryBooks(res: MyResource<CategoryResult>) {
        when (res.status) {
            MyStatus.SUCCESS -> {
                val l = res.data
                categoryAdapter = CategoryAdapter(l!!.results.books,object :CategoryAdapter.OnItemClickListener{
                    override fun onItemClick(book: com.example.experiment.Model.category.Book) {
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra("category","category")
                        intent.putExtra("key",book)
                        startActivity(intent)
                    }

                })
                binding.trendingBooksRV.adapter = categoryAdapter
//                Log.d(TAG, "showTrendingBooks: $l")
//                Toast.makeText(this, l.toString(), Toast.LENGTH_SHORT).show()

            }
            MyStatus.ERROR -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

            }
            MyStatus.LOADING->{

            }
        }
    }

    override fun showTitleBooks(res: MyResource<TitleResult>) {
        when (res.status) {
            MyStatus.SUCCESS -> {
                val l = res.data!!.results

                l.forEach {
                    binding.titkeImage.visibility = View.VISIBLE
                    binding.title.visibility = View.VISIBLE
                    binding.description.visibility = View.VISIBLE
                    binding.title.text = it.book_title
                    binding.description.text = it.summary
                }

                if (binding.title.text.toString().isEmpty()){
                    binding.titkeImage.visibility = View.GONE
                    presenter?.onSearchAuthor(binding.editetext.text.toString())



                }



//                Log.d(TAG, "showTrendingBooks: $l")


            }
            MyStatus.ERROR -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

            }
            MyStatus.LOADING->{

            }
        }
    }

    override fun showAuthorBooks(res: MyResource<AuthorResult>) {
        when (res.status) {
            MyStatus.SUCCESS -> {
                val l = res.data
                binding.aftorRv.visibility = View.VISIBLE
                authorAdapter = AuthorAdapter(res.data!!.results)
                binding.aftorRv.adapter = authorAdapter









            }
            MyStatus.ERROR -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

            }
            MyStatus.LOADING->{

            }
        }
    }

    override fun showAllCategory(res: MyResource<AllCategory>) {

        when (res.status) {
            MyStatus.SUCCESS -> {
                val l = res.data
                categoryListAdapter = CategoryListAdapter(res.data!!.results)
                binding.categoriesRV.adapter = categoryListAdapter

            }
            MyStatus.ERROR -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

            }
            MyStatus.LOADING->{

            }
        }


    }
}