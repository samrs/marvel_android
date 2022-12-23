package com.example.marvel.view

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.databinding.ActivityMainBinding
import com.example.marvel.model.api.MarvelAPiService
import com.example.marvel.view.adapter.CharactersAdapter
import com.example.marvel.viewmodel.MainViewModel
import com.example.marvel.viewmodel.factory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this,
            MainViewModelFactory(MarvelAPiService.marvelApiService)
        ).get(MainViewModel::class.java)
    }

    private val charactersAdapter by lazy {
        CharactersAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.charactersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.right = 30
                    outRect.left = 30
                    outRect.bottom = 30
                }
            })
            adapter = charactersAdapter
        }
        setUpObserver()
    }


    private fun setUpObserver() {
        viewModel.listCharacters.observe(this, { characters ->
            charactersAdapter.addData(characters)
            binding.loadingProgressBar.visibility = GONE
        })
    }
}