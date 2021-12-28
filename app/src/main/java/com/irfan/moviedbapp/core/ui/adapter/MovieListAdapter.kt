package com.irfan.moviedbapp.core.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irfan.moviedbapp.R
import com.irfan.moviedbapp.core.domain.model.Movie
import com.irfan.moviedbapp.core.utils.URL
import com.irfan.moviedbapp.databinding.ItemMovieBinding

class MovieListAdapter(layoutManager: GridLayoutManager): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var listMovie = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListMovie: List<Movie>?) {
        if (newListMovie == null)
            return
        listMovie.clear()
        listMovie.addAll(newListMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMovieBinding.bind(itemView)
        fun bind(movie: Movie) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(URL.getImagePath+movie.posterPath)
                    .fitCenter()
                    .into(ivPoster)
                tvTitle.text = movie.title
                root.setOnClickListener {
                    onItemClick?.invoke(listMovie[adapterPosition])
                }
            }
        }
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(true)
    }
}