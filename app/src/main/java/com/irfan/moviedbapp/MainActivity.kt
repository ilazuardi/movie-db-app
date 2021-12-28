package com.irfan.moviedbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.irfan.moviedbapp.core.data.Resource
import com.irfan.moviedbapp.core.ui.ViewModelFactory
import com.irfan.moviedbapp.core.ui.adapter.MovieListAdapter
import com.irfan.moviedbapp.core.utils.EXTRAS.EXTRA_DATA
import com.irfan.moviedbapp.databinding.ActivityMainBinding
import com.irfan.moviedbapp.detail.DetailActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var movieAdapter: MovieListAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val mainViewModel: MainViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        gridLayoutManager = GridLayoutManager(this, 2)
        movieAdapter = MovieListAdapter(gridLayoutManager)

        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        mainViewModel.movie.observe(this@MainActivity, {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> binding.pbMovie.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.pbMovie.visibility = View.GONE
                        movieAdapter.setData(it.data)
                    }
                    is Resource.Error -> {
                        binding.pbMovie.visibility = View.GONE
                        binding.errorMessageTv.visibility = View.VISIBLE
                        binding.errorMessageTv.text = it.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })

        with(binding.rvMovie) {
            layoutManager = gridLayoutManager
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}