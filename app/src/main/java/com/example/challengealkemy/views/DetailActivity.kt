package com.example.challengealkemy.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.challengealkemy.BuildConfig
import com.example.challengealkemy.databinding.MovieDetailsBinding

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: MovieDetailsBinding
    private val viewModel: MovieDetailsViewModel by viewModels(
        factoryProducer = {DetailViewModelFactory( )}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val exit =bundle?.getInt("id")
        exit?.let { viewModel.newdetail(it) }

        viewModel.movieDetail.observe(this){
            movie -> binding.movieTitle.text = movie?.title
                     binding.movieOverview.text= movie?.overview
                     binding.movieReleaseDate.text = movie?.releaseDate
                     binding.movieOriginalLeng.text = movie?.originalLeng
                     binding.popularity.text = movie?.popularity.toString()

            Glide.with(this)
                .load("${ BuildConfig.POS_URL}${movie?.backdro}")
                .into(binding.movieBackdrop)

            Glide.with(this)
                .load("${ BuildConfig.POS_URL}${movie?.posterPath}")
                .into(binding.moviePoster)
        }
    }
}
