package com.irfan.moviedbapp.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.irfan.moviedbapp.MainActivity
import com.irfan.moviedbapp.R
import com.irfan.moviedbapp.core.domain.model.Movie
import com.irfan.moviedbapp.core.utils.EXTRAS.EXTRA_DATA
import com.irfan.moviedbapp.core.utils.URL
import com.irfan.moviedbapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
        binding.pbDetail.visibility = View.GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = "Detail Photo"
            binding.apply {
                Glide.with(this@DetailActivity)
                    .load(URL.getImagePath+it.posterPath)
                    .fitCenter()
                    .into(ivPosterDetail)
                tvTitle.text = it.title
                tvReleaseDate.text = it.releaseYear
                tvVoteAverage.text = it.voteAverage.toString()
                tvDesc.text = it.description
                tvLanguage.text = it.originalLanguage
            }
        }
    }
}