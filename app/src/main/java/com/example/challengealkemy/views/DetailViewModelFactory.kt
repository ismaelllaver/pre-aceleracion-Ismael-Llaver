package com.example.challengealkemy.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challengealkemy.data.MoviesRemoteDataSource
import com.example.challengealkemy.data.MoviesRepository

class DetailViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val remoteDataSource = MoviesRemoteDataSource()
        val repository = MoviesRepository(remoteDataSource)
        val viewModel = MovieDetailsViewModel(repository)

        return viewModel as T
    }

}