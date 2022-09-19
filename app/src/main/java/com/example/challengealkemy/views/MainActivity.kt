package com.example.challengealkemy.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengealkemy.data.Movie

import com.example.challengealkemy.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MoviesViewModel by viewModels(
        factoryProducer = {MoviesViewModelFactory( )}

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.popularMovies.layoutManager = LinearLayoutManager(this)

        viewModel.movies.observe(this){ movies ->
            binding.popularMovies.adapter = movies?.let {
                MoviesAdapter(it, object: MoviesAdapter.MovieListener{
                    override fun select(movies: Movie) {
                        var id = movies.id
                        goDetail(id)
                    }
                })
            }
        }
        viewModel.newmovie()
        }

    fun goDetail (id: Int){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
        }
    }