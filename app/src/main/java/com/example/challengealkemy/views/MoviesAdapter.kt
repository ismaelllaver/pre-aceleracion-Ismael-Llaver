package com.example.challengealkemy.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.challengealkemy.BuildConfig
import com.example.challengealkemy.data.Movie
import com.example.challengealkemy.databinding.ItemMenuBinding

class MoviesAdapter(
    private val movies: List<Movie>,
    private val listener: MovieListener
    ) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    interface MovieListener {
        fun select(movies: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(layoutInflater,parent,false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MoviesViewHolder(private val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (movies: Movie){
            Glide.with(itemView)
                .load("${ BuildConfig.POS_URL}${movies.posterPath}")
                .transform(CenterCrop())
                .into(binding.itemMoviePoster)
            binding.root.setOnClickListener{
                listener.select(movies)
            }
            binding.titleMovie.text = movies.title
        }
    }
}






